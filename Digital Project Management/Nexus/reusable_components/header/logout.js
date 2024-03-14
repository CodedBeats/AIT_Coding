import { auth } from "../../firebase/misc/firebaseConfig.js"

const logoutButton = document.getElementById("logout-btn");

// Add a click event listener to the logout button
logoutButton.addEventListener("click", () => {
    // Call the Firebase signOut method to log the user out
    auth.signOut()
        .then(() => {
            // Redirect the user to the login page or any other page you want
            // For example, redirect to the homepage after logout
            window.location.href = "../../home_page/homepage.html";
        })
        .catch((error) => {
            console.error("Error signing out:", error);
        });
});
