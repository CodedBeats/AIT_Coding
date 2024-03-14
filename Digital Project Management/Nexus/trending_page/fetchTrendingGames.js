import { collection, query, orderBy, getDocs, where } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { db } from "../firebase/misc/firebaseConfig.js";

// Function to fetch trending games from db
async function fetchTrendingGames(threshold) {
    try {
        const trendingGamesSnapshot = await getDocs(
            query(collection(db, "games"),
                where("popularity", ">=", threshold),
                orderBy("popularity", "desc")
            )
        );
    
        const trendingGames = [];
        trendingGamesSnapshot.forEach((doc) => {
            const game = doc.data();
            trendingGames.push({ id: doc.id, ...game });
        });

        return trendingGames;
    } catch (error) {
        console.error("Error fetching trending games:", error);
        return [];
    }
}

export { fetchTrendingGames };
