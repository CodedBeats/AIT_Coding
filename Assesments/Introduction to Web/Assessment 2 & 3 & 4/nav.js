// DOM elements
const sideNav = document.getElementById("dom-side-nav")
const main = document.getElementById("main")

// Toggle Nav function
let openNav = () => {
    if (sideNav.style.display === "none") {
        sideNav.style.display = "block"
        
        // phone view adjustments 
        if (window.screen.width <= 680) {
            console.log("xx")
            sideNav.style.width = "100%";
            sideNav.style.marginLeft = "100%";
            document.body.style.backgroundColor = "rgba(0,0,0,0.2)";
        } 
        // desktop view adjustments
        else {
            setTimeout(() => { sideNav.style.width = "250px" }, 0);
            document.body.style.marginLeft = "250px"
            document.body.style.backgroundColor = "rgba(0,0,0,0.2)";
        }
    } else {
        sideNav.style.width = "0";
        document.body.style.marginLeft = "0";
        document.body.style.backgroundColor = "white";
        setTimeout(() => { sideNav.style.display = "none" }, 500);
    }
}

// Close nav button
let closeNav = () => {
    sideNav.style.width = "0";
    setTimeout(() => { sideNav.style.display = "none" }, 500);
    main.style.marginLeft = "0";
    document.body.style.marginLeft = "0";
    document.body.style.backgroundColor = "white";
}