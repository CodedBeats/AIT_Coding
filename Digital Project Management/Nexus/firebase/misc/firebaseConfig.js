import { initializeApp } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-app.js";
import { getFirestore } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { getAuth, onAuthStateChanged } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-auth.js";

// Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyARqst_oHsoaxRcTiyeTACGLo80A_r_Lc4",
    authDomain: "nexus-2f89a.firebaseapp.com",
    projectId: "nexus-2f89a",
    storageBucket: "nexus-2f89a.appspot.com",
    messagingSenderId: "50014803493",
    appId: "1:50014803493:web:0f47f4326385c2043991cc",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
async () => {
    await setPersistence(auth, browserLocalPersistence);
};
const db = getFirestore(app);

export { db, auth };
