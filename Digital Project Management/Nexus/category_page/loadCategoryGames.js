import { fetchCategoryGames } from "./fetchCategoryGames.js";
import { renderGameCard } from "./renderGameCard.js";

async function loadCategoryGames() {
    const categories = ["Puzzle", "Strategy", "Tower-Defense", "Sci-Fi", "Space", "Racing", "Farming", "Trivia", "Sport", "Pirate"];
    let categoryGames;

    categories.forEach(async (category) => {
        const categoryContainer = document.getElementById(category);
        categoryGames = await fetchCategoryGames(category);

        if (categoryGames.length === 0) {
            const comingSoonDiv = document.createElement("div");
            comingSoonDiv.classList.add("coming-soon");
            comingSoonDiv.textContent = "Coming Soon";
            categoryContainer.appendChild(comingSoonDiv);
        } else {
            categoryGames.forEach((game) => {
                const gameCard = renderGameCard(game);
                categoryContainer.appendChild(gameCard);
            });
        }
    });
};

export { loadCategoryGames };
