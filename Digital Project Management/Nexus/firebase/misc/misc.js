import { collection, getDocs } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js"
import { db } from "./firebaseConfig.js"

// change this to to a custom ID func
async function getTotalDocuments() {
    const collectionRef = collection(db, "popularity");

    try {
        const querySnapshot = await getDocs(collectionRef);

        // Access the size property of the QuerySnapshot to get the total number of documents
        const totalDocuments = querySnapshot.size;

        console.log("Total number of documents:", totalDocuments);
        return totalDocuments
        
    } catch (error) {
        console.error("Error getting documents:", error);
    }
}

export { getTotalDocuments }
