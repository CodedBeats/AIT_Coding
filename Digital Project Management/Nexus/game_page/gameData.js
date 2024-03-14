import { doc, getDoc, getDocs, updateDoc, collection, query, where } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js"
import { db } from "../firebase/misc/firebaseConfig.js"


// === Reusability === //
async function getGameDoc(collectionName, gameName) {
    const gamesCollectionRef = collection(db, collectionName);
    const q = query(gamesCollectionRef, where('name', '==', gameName));
    
    const querySnapshot = await getDocs(q);
    if (!querySnapshot.empty) {
        const docSnapshot = querySnapshot.docs[0]; // Assuming there's only one match
        return docSnapshot.id; // Access the id property
    } else {
        return null; // No match found
    }
}

async function getDocID(colName) {
    // Get the selected gameId from the URL parameter
    const urlParams = new URLSearchParams(window.location.search);
    const gameName = urlParams.get("gameId");

    // get docID from doc name
    const docId = await getGameDoc(colName, gameName);

    return docId;
}
// ============================== //




// === Game Popularity === //
async function updatePopularity() {
    const collectionName = "games";
    const fieldName = "popularity";
    const docId = await getDocID(collectionName);

    // Get the current value from db
    const docRef = doc(db, collectionName, docId);
    const docSnapshot = await getDoc(docRef);
    const currentValue = docSnapshot.data()[fieldName];

    // Modify the value
    const updatedValue = currentValue + 1;

    // update popularity
    const data = { [fieldName]: updatedValue };

    updateDoc(docRef, data)
        .then(() => {
            console.log("Game popularity updated successfully!");
        })
        .catch((error) => {
            console.error("Error updating popularity:", error);
        });
}
// ============================== //




// === Game Highschore === //
async function updateHighscore(score) {
    const collectionName = "games";
    const fieldName = "highscore";
    const docId = await getDocID(collectionName);

    // Get the current value from db
    const docRef = doc(db, collectionName, docId);
    const docSnapshot = await getDoc(docRef);
    const currentValue = docSnapshot.data()[fieldName];
    const newValue = parseInt(score);

    // check if score is better than highscore
    if (newValue > currentValue) {
        // set highscore text field to new value (so don't need to reload page)
        const highscoreTextField = document.getElementById("highscore");
        highscoreTextField.textContent = newValue;

        // update highscore
        const data = { [fieldName]: newValue };

        updateDoc(docRef, data)
            .then(() => {
                console.log(`Game highscore (${newValue}) updated successfully`);
            })
            .catch((error) => {
                console.error("Error updating popularity:", error);
            });
    } else {
        console.log(`score (${newValue}) isn't better than highscore`)
    }
}

// Callback function to execute when a mutation is observed
const mutationCallback = (mutationsList, observer) => {
    let highscoreText = document.getElementById('session-highscore');
    for (const mutation of mutationsList) {
        if (mutation.type === 'childList' && mutation.target === highscoreText) {
            // The text content of the target element has changed
            const newTextContent = highscoreText.textContent;
            // Do something with the new text content
            updateHighscore(newTextContent);
        }
    }
};

function getHighscoreChange() {
    let highscoreText = document.getElementById('session-highscore');

    // Create a new MutationObserver instance with the mutationCallback
    const observer = new MutationObserver(mutationCallback);

    // Configure the observer to watch for changes in the text content
    const config = { characterData: true, childList: true, subtree: true };
    observer.observe(highscoreText, config);

    // To disconnect the observer later:
    // observer.disconnect();
}
// ============================== //



// === Game Data === //
async function loadGameData() {
    try {
        const collectionName = "games"; // Replace with your collection name
        const docId = await getDocID(collectionName);
        
        if (docId) {
            // Get the document reference
            const docRef = doc(db, collectionName, docId);
            
            // Fetch the document data
            const docSnapshot = await getDoc(docRef);
            

            // Get the doc data
            const gameName = docSnapshot.data().name
            const gamePopularity = docSnapshot.data().popularity;
            const gameDeveloper = docSnapshot.data().createdBy;
            const timestamp = new Date(docSnapshot.data().createdAt.seconds * 1000); // Convert to milliseconds
            // get readable time haha
            const gameReleased = timestamp.toLocaleDateString();
            const gameHighscore = docSnapshot.data().highscore;
            const gameCategory = docSnapshot.data().category;
            const gameObjective = docSnapshot.data().howToPlay;
            const gameAbout = docSnapshot.data().about;
            

            // get text fields
            const gameNameTextElement = document.getElementById("game-name");
            const popularityTextElement = document.getElementById("popularity");
            const developerTextElement = document.getElementById("developer");
            const releasedTextElement = document.getElementById("released");
            const highscoreTextElement = document.getElementById("highscore");
            const categoryTextElement = document.getElementById("category");
            const objectiveTextElement = document.getElementById("how-to-play");
            const aboutTextElement = document.getElementById("about");


            // load data into text fields
            gameNameTextElement.textContent = gameName;
            popularityTextElement.textContent = gamePopularity;
            developerTextElement.textContent = gameDeveloper;
            releasedTextElement.textContent = gameReleased;
            highscoreTextElement.textContent = gameHighscore;
            categoryTextElement.textContent = gameCategory;
            objectiveTextElement.textContent = gameObjective
            aboutTextElement.textContent = gameAbout

        } else {
            console.log("No matching document found.");
        }
    } catch (error) {
        console.error("Error updating highscore text:", error);
    }
}
// ============================== //


// update game data on page load
document.addEventListener("DOMContentLoaded", () => {
    updatePopularity();
    getHighscoreChange();
    loadGameData();
});
