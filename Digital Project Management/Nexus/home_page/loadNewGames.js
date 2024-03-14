import { fetchNewGames } from "./fetchNewGames.js";

// Function to create a game card element
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

    const gameCreator = document.createElement("div");
    gameCreator.classList.add("game-creator");
    gameCreator.textContent = `Creator: ${game.createdBy}`;
    gameCard.appendChild(gameCreator);

    const gameTimestamp = document.createElement("div");
    gameTimestamp.classList.add("game-timestamp");
    const timestamp = new Date(game.createdAt.seconds * 1000); // Convert to milliseconds
    const options = { day: "numeric", month: "numeric", year: "numeric" };
    gameTimestamp.textContent = `Released: ${timestamp.toLocaleDateString(
        "en-AU",
        options
    )}`;
    gameCard.appendChild(gameTimestamp);

    return gameCard;
}

// Function to load and display games
async function loadAndDisplayGames() {
    const gameContainer = document.getElementById("new-games-container");
    const games = await fetchNewGames();

    if (games.length === 0) {
        gameContainer.textContent = "No games available in the past 30 days.";
        return;
    }

    games.forEach((game) => {
        const gameCard = renderGameCard(game);
        gameContainer.appendChild(gameCard);
    });
}

// load new games
document.addEventListener("DOMContentLoaded", loadAndDisplayGames);
