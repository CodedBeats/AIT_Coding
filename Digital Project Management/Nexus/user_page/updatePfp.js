import { getDoc, doc, updateDoc } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { onAuthStateChanged } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-auth.js";
import { db, auth } from "../firebase/misc/firebaseConfig.js";

const profileIcons = document.querySelectorAll('.pro-pic');

onAuthStateChanged(auth, (user) => {
    if (user) {
        profileIcons.forEach(img => {
            img.addEventListener('click', async (event) => {
                event.preventDefault();

                const newProfileImg = img.getAttribute('src');

                // Update the user's profile image URL in the database
                try {
                    const userRef = doc(db, "users", user.uid);
                    await updateDoc(userRef, {
                        pfp: newProfileImg
                    });
                    console.log('Profile image updated successfully.');
                    
                    // link to profile page
                    window.location.href = "../user_page/userpage-profile.html";

                } catch (error) {
                    console.error('Error updating profile image:', error);
                }
            });
        });
    }
});
