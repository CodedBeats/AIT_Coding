import { auth } from "../../firebase/misc/firebaseConfig.js";

// Function to handle the user's login status
function handleLoginStatus(user) {
    const loadingPage = document.getElementById("loading-container");
    const signupBtn = document.getElementById("signup-btn");
    const loginBtn = document.getElementById("login-btn");
    const userIcon = document.getElementById("user-btn");
    const logoutBtn = document.getElementById("logout-btn");

    // console.log(logoutBtn)

    if (user) {
        // User is logged in, show the user icon and hide signup and login buttons
        signupBtn.style.display = "none";
        loginBtn.style.display = "none";
        userIcon.style.display = "block";
        logoutBtn.style.display = "block";
    } else {
        // User is not logged in, show signup and login buttons and hide user icon
        signupBtn.style.display = "block";
        loginBtn.style.display = "block";
        userIcon.style.display = "none";
        logoutBtn.style.display = "none";
    }

    // Hide loading page
    loadingPage.style.display = "none";
}

// Check the user's login status on page load and whenever it changes
auth.onAuthStateChanged(handleLoginStatus);
