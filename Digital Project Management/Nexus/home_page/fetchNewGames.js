import { collection, query, orderBy, getDocs, where } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { db } from "../firebase/misc/firebaseConfig.js";


// Function to fetch new games from the past 30 days
async function fetchNewGames() {
    const thirtyDaysAgo = new Date();
    thirtyDaysAgo.setDate(thirtyDaysAgo.getDate() - 30);

    const today = new Date();
    today.setHours(0, 0, 0, 0);
  
    // Fetch games from Firestore, order by timestamp, and filter by past 30 days
    const q = query(
        collection(db, "games"),
        where("createdAt", ">=", thirtyDaysAgo),
        where("createdAt", "<", today), // Exclude today
        orderBy("createdAt", "desc")
    );
  
    const querySnapshot = await getDocs(q);
    return querySnapshot.docs.map((doc) => doc.data());
}

export { fetchNewGames }
