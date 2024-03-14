// ===== Loading component ===== //
let createLoadingComponent = () => {
    let loadingComponentHTML = `
    <div class="loader">
        <div class="loading-pacman">
            <div class="pacman"></div>
            <div class="balls">
                <div class="ball ball1"></div>
                <div class="ball ball2"></div>
                <div class="ball ball3"></div>
                <div class="ball ball4"></div>
                <div class="ball ball5"></div>
            </div>
        </div>
    </div>
    `;

    return loadingComponentHTML;
}


// ===== Load Lasers Canvas ===== //
const loadingComponentHTML = createLoadingComponent();
document.getElementById("loading-container").innerHTML = loadingComponentHTML;
