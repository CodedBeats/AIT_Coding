import { getAuth, signInWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-auth.js";
import { auth } from "../firebase/misc/firebaseConfig.js";

const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const loginBtn = document.getElementById("loginBtn");
const errorMessage = document.getElementById("errorMessage");

// Function to handle login
async function handleLogin() {
    const email = emailInput.value;
    const password = passwordInput.value;

    try {
        // Sign in with email and password using Firebase Authentication
        await signInWithEmailAndPassword(auth, email, password);

        // Redirect the user to a page
        window.location.href = "../home_page/homepage.html";
    } catch (error) {
        errorMessage.textContent = error.message;
    }
}

// Add event listener to the login button
loginBtn.addEventListener("click", handleLogin);
