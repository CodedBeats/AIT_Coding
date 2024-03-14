import { loadCategoryGames } from "./loadCategoryGames.js";
import { categoryLinks } from "./categoryLinks.js";

document.addEventListener("DOMContentLoaded", async () => {
    loadCategoryGames();
    // wait 1s
    setTimeout(function() { 
        categoryLinks()
    }, 1000);
})