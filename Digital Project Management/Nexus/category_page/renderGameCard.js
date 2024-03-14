// renderGameCard.js
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
    gameImgContainer.appendChild(gameImage);

    const gameTitle = document.createElement("div");
    gameTitle.classList.add("game-title");
    gameTitle.textContent = game.name;
    gameCard.appendChild(gameTitle);
  
    const gameReleaseStatus = document.createElement("div");
    gameReleaseStatus.classList.add("game-release-status");
    gameReleaseStatus.textContent = `Status: ${game.releaseStatus}`;
    gameCard.appendChild(gameReleaseStatus);

    return gameCard;
}

export { renderGameCard };
