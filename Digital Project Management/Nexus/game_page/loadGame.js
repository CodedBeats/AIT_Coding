// Get the selected gameId from the URL parameter
const urlParams = new URLSearchParams(window.location.search);
const gameId = urlParams.get("gameId");

// Create a script element
const scriptElement = document.createElement("script");

// set page title to game name
const pageTitle = document.getElementById("page-title");
pageTitle.textContent = `${gameId} - Nexus`;

// Set the source of the script based on the selected game
if (gameId === "Snake") {
    console.log("Snake game")
    loadGame("../games/snake/snake.js", "../games/snake/snake.css", 900, 600);
} 
else if (gameId === "Exo-Defense") {
    console.log("Tower defense game")
    loadGame("../games/tower_defense/index.js", "../games/tower_defense/style.css", 900, 600);
}
// game not available yet
else {
    const canvas = document.getElementById('gameCanvas');
    const restartBtn = document.getElementById("restart-game")
    const canvasContainer = document.getElementById("canvas-container")
    const gameDataContainer = document.getElementById("game-info-container")
    console.log("WIP");
    loadWip();

    // hide game content
    canvas.style.display = "none";
    restartBtn.style.display = "none";
    canvasContainer.style.display = "none";
    gameDataContainer.style.display = "none";
}

// load apropriate game and set canvas width and height
function loadGame(scriptSrc, styleHref, canvasWidth, canvasHeight) {
    const scriptElement = document.createElement("script");
    scriptElement.src = scriptSrc;
    document.getElementById("gameScript").appendChild(scriptElement);

    const stylesheetElement = document.getElementById("gameStylesheet");
    stylesheetElement.href = styleHref;

    const canvas = document.getElementById('gameCanvas');
    canvas.width = canvasWidth;
    canvas.height = canvasHeight;
}

// load WIP overlay
function loadWip() {
    const wipOverlay = document.getElementById('wip');
    wipOverlay.classList.add('active');
}

// Append the script element to the page
document.getElementById("gameScript").appendChild(scriptElement);
