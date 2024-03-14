document.addEventListener("DOMContentLoaded", () => {
    const backToTopButton = document.getElementById("back-to-top-button");

    if (backToTopButton) {
        backToTopButton.addEventListener("click", () => {
            window.scrollTo({ top: 0, behavior: "smooth" });
        });

        window.addEventListener("scroll", () => {
            if (window.scrollY > 300) {
                backToTopButton.style.display = "block";
            } else {
                backToTopButton.style.display = "none";
            }
        });
    }
});
