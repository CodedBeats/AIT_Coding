document.addEventListener('DOMContentLoaded', function() {
    function setActiveMenuItem() {
        const menuItems = document.querySelectorAll(".side-nav .nav-menu a");
        const currentPage = getCurrentPage();
        
        menuItems.forEach((item) => {
            const pageName = item.dataset.page;
            // console.log(currentPage, pageName)
            if (currentPage === pageName) {
                item.classList.add("active");
            } else {
                item.classList.remove("active");
            }
        });
    }

    function getCurrentPage() {
        // Extract the current page name from the URL (e.g., "page1" from "http://example.com/page1.html")
        const path = window.location.pathname;
        const currentPage = path.substring(
            path.lastIndexOf("/") + 1,
            path.lastIndexOf(".html")
        );
        return currentPage;
    }

    // Call the function to set the active menu item on page load
    setActiveMenuItem();
});