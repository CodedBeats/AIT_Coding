// ===== Header component ===== //
let createFooterComponent = () => {
    let footerComponentHTML = `
    <div class="footer">
        <p>Nexus v1.0</p>
        <button id="back-to-top-button">Back to Top</button>
    </div>
    `;

    return footerComponentHTML;
}


// ===== Load Header ===== //
const footerComponentHTML = createFooterComponent();
document.getElementById("footer-container").innerHTML = footerComponentHTML;
