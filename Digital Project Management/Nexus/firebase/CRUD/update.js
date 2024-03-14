import { doc, getDoc, updateDoc } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js"
import { db } from "../misc/firebaseConfig.js"


async function updateDocument() {
    // change these to params maybe
    const collectionName = "popularity";
    const docId = "game1";
    const fieldName = "pop";

    // Get the current value from Firestore
    const docRef = doc(db, collectionName, docId);
    const docSnapshot = await getDoc(docRef);
    const currentValue = docSnapshot.data()[fieldName];

    // Modify the value
    const updatedValue = currentValue + 1;

    // Use the updateDoc function to update the specific field
    const data = { [fieldName]: updatedValue };

    updateDoc(docRef, data)
        .then(() => {
            console.log("Document updated successfully!");
        })
        .catch((error) => {
            console.error("Error updating document:", error);
        });
}

export { updateDocument }
