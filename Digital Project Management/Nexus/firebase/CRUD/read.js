import { collection, doc, getDoc } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js"
import { db } from "../misc/firebaseConfig.js"

async function getData(collectionName, id) {
    // Replace 'users' with the name of the collection where user data is stored
    const dataRef = doc(collection(db, collectionName), id);

    try {
        // fetch data from Firestore
        const dataSnapshot = await getDoc(dataRef);
        if (dataSnapshot.exists()) {

            const data = dataSnapshot.data();

            console.log("data:", data);
            return data;

        } else {
            console.log("data not found.");
            return null;
        }
    } catch (error) {
        console.error("Error getting user data:", error);
    }
}

export { getData }