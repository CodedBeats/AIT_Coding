import { collection, doc, setDoc, } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { db } from "../misc/firebaseConfig.js";
import { getTotalDocuments } from "../misc/misc.js";

async function createDocument(collectionName, newDocumentData) {
    const collectionRef = collection(db, collectionName);

    // set custom ID here...maybe turn into a func
    const documentId = `doc${(await getTotalDocuments()) + 1}`;

    try {
        // add doc
        await setDoc(doc(collectionRef, documentId), newDocumentData);

        console.log("Document created with ID:", documentId);
    } catch (error) {
        console.error("Error creating document:", error);
    }
}

export { createDocument };
