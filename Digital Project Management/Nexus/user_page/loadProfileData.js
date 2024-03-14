import { getDoc, doc } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { onAuthStateChanged } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-auth.js";
import { db, auth } from "../firebase/misc/firebaseConfig.js";


async function loadProfile() {
    // Check if a user is logged in
    const user = auth.currentUser;

    if (user) {
        try {
            // Retrieve the user's profile document from db
            const userRef = doc(db, "users", user.uid);
            const profileSnapshot = await getDoc(userRef);

            if (profileSnapshot.exists()) {
                // Get the user's profile data
                const profileData = profileSnapshot.data();
                console.log(profileData.email, profileData.username, profileData.password);

                // Update the profile page HTML elements with the user's information
                document.getElementById("email").textContent = profileData.email;
                document.getElementById("username").textContent = profileData.username;
                document.getElementById("password").textContent = profileData.password;
                document.getElementById("pro-pic").src = profileData.pfp;

            } else {
                console.log("User profile not found");
            }
        
        // handle user error
        } catch (error) {
            console.error("Error loading user profile:", error);
        }
    } else {
        console.log("No user is currently logged in");
    }
}


// Listen for changes in authentication state
onAuthStateChanged(auth, (user) => {
    if (user) {
        // diaply loading page
        const loadingPage = document.getElementById("loading-container")

        console.log("User is signed in");

        // load the profile
        loadProfile()

        // hide loading page after data load
        loadingPage.style.display = "none"

    } else {
        // User is signed out
        console.log("User is signed out.");
    }
});
