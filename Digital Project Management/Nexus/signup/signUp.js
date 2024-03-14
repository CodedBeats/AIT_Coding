// signUp.js
import { createUserWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-auth.js";
import { setDoc, doc } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { auth, db } from "../firebase/misc/firebaseConfig.js";

// Function to handle user sign-up
async function signUp(email, password, username, pfp) {
    try {
        // Create a new user using Firebase Authentication
        const userCredential = await createUserWithEmailAndPassword(
            auth,
            email,
            password
        );
        const user = userCredential.user;

        // Create a new document for the user in the db
        const userRef = doc(db, "users", user.uid);
        const userData = {
            email: user.email,
            password: password,
            username: username,
            pfp: "../images/profile-pic/profile_pic1.png"
        };
        await setDoc(userRef, userData);

        console.log("User account created successfully!");
        console.log(user.email, password, username, pfp);

        // link to home
        window.location.href = "../home_page/homepage.html";
        
    } catch (error) {
        console.error("Error creating user account:", error.message);
    }
}

// Example usage in your sign-up form submit handler
const signUpForm = document.getElementById("signUpForm");

signUpForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const username = document.getElementById("username").value;

    signUp(email, password, username);
});
