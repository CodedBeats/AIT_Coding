import { collection, getDocs } from "https://www.gstatic.com/firebasejs/9.4.0/firebase-firestore.js";
import { db } from "../../firebase/misc/firebaseConfig.js";

async function handleSearchSubmit(e) {
    e.preventDefault();

    const searchInput = document.querySelector(".search-input");
    const searchQuery = searchInput.value.trim(); // Get the search query and remove leading/trailing spaces
    console.log(`search: ${searchQuery}`)

    if (searchQuery) {
        // Call a function to perform the search and render the results
        await searchAndRenderResults(searchQuery);
    }
}

// search and render results
async function searchAndRenderResults(q) {
    try {
        // Fetch all games from the database
        const gamesSnapshot = await getDocs(collection(db, "games"));
        
        // Process the snapshot to extract game data and filter matching results
        const matchingGames = gamesSnapshot.docs
            .map(doc => doc.data())
            .filter(game => game.name.toLowerCase().includes(q.toLowerCase()));

        // Render the matching games on the page
        renderSearchResults(matchingGames);
    } catch (error) {
        console.error("Error searching for games:", error);
    }
}


function renderGameCard(game) {
    const gameCard = document.createElement("a");
    gameCard.classList.add("game-card");
    gameCard.href = `../game_page/gamepage.html?gameId=${game.name}`;

    const gameImgContainer = document.createElement("div");
    gameImgContainer.classList.add("game-image-container");
    gameCard.appendChild(gameImgContainer);

    const gameImage = document.createElement("img");
    gameImage.classList.add("game-image");
    gameImage.src = game.imgPath;
    gameCard.appendChild(gameImage);

    const gameTitle = document.createElement("div");
    gameTitle.classList.add("game-title");
    gameTitle.textContent = game.name;
    gameCard.appendChild(gameTitle);
  
    const gameReleaseStatus = document.createElement("div");
    gameReleaseStatus.classList.add("search-game-release-status");
    gameReleaseStatus.textContent = `Status: ${game.releaseStatus}`;
    gameCard.appendChild(gameReleaseStatus);

    return gameCard;
}

// render search results
function renderSearchResults(results) {
    const resultsList = document.getElementById("resultsList");
    resultsList.innerHTML = ""; // Clear previous results

    if (results.length === 0) {
        const noResultsMessage = document.createElement("p");
        noResultsMessage.classList.add("no-results");
        noResultsMessage.textContent = "We didn't find anything matching that.";
        resultsList.appendChild(noResultsMessage);
    } else {
        // Loop through the results and create game cards to display them
        results.forEach(game => {
            const gameCard = renderGameCard(game); // Reuse the renderGameCard function
            resultsList.appendChild(gameCard);
        });
    }

    showSearchResults(); // Show the search results
}

document.addEventListener("DOMContentLoaded", () => {
    const searchForm = document.querySelector(".search-form");
    // Attach event listeners
    searchForm.addEventListener("submit", handleSearchSubmit)
});








////////////////////////////////////////
const searchSubmitBtn = document.getElementById("submit-search");
const searchResults = document.getElementById("searchResults");
const closeButton = document.getElementById("closeButton");

// Function to show search results
function showSearchResults() {
    searchResults.classList.add("active");
}

// Function to hide search results
function hideSearchResults() {
    searchResults.classList.remove("active");
}

// Attach event listeners
searchSubmitBtn.addEventListener("click", showSearchResults);
closeButton.addEventListener("click", hideSearchResults);
