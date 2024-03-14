function categoryLinks() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const category = urlParams.get("category");
    const categoryName = category.charAt(0).toUpperCase() + category.slice(1);

    if (categoryName) {
        const targetSection = document.getElementById(categoryName);
        
        if (targetSection) {
            const headerHeight = document.getElementById("header-container").offsetHeight;
            const targetOffset = (targetSection.offsetTop - headerHeight) - 120;

            window.scrollTo({
                top: targetOffset,
                behavior: "smooth"
            });
        }
    }
}
    
export { categoryLinks };
