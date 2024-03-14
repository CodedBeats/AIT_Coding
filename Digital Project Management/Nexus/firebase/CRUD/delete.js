// deleteDocument.js
import { doc, deleteDoc } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { db } from "../misc/firebaseConfig.js";

async function deleteDocument(collectionName, docID) {
    const docRef = doc(db, collectionName, docID);

    try {
        await deleteDoc(docRef);
        console.log("Document deleted successfully.");

    } catch (error) {
        console.error("Error deleting document:", error);
    }
}

export { deleteDocument };
