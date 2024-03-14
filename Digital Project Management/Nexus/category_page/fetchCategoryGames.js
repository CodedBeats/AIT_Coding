import { collection, query, where, getDocs } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { db } from "../firebase/misc/firebaseConfig.js";

async function fetchCategoryGames(category) {
    const q = query(collection(db, "games"), where("category", "==", category));
    const querySnapshot = await getDocs(q);
    return querySnapshot.docs.map((doc) => doc.data());
}

export { fetchCategoryGames };
