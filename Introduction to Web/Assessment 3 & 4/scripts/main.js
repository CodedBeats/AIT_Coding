// ======================== Nav ======================== //
// Toggle Nav func
let openNav = () => {
    const sideNav = document.getElementById("dom-side-nav")
    if (sideNav.style.display === "none") {
        sideNav.style.display = "block"
        
        // phone view adjustments 
        if (window.screen.width <= 800) {
            console.log(sideNav)
            setTimeout(() => { sideNav.style.width = "100vw"}, 0);
            document.body.style.height = "100%"
            document.body.style.marginLeft = "100%"
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

// Close nav func
let closeNav = () => {
    const sideNav = document.getElementById("dom-side-nav")
    sideNav.style.width = "0";
    document.body.style.marginLeft = "0";
    document.body.style.backgroundColor = "white";
    setTimeout(() => { sideNav.style.display = "none" }, 500);
}


// ======================== DOM Elements ======================== //
// Add css func
let taskDone = (id) => {
    let listElement = document.getElementById(id);
    listElement.classList.toggle("strike-thourgh");
}

// Lets the user know what this would do, but it's functionality that I wont build
let alertMessage = (message) => {
    alert(message)
    console.log("clicked")
}

// Toggle dropdown with divs of text
let dropdown = (t) => {
    let btnTitle = document.querySelector(".added-features-title")
    let text = document.querySelector(t)
    if (text.style.display === "block") {
        text.style.display = "none"
        btnTitle.innerHTML = `Added Features <i class="fa-solid fa-arrow-down"></i>`
    } else {
        text.style.display = "block"
        btnTitle.innerHTML = `Added Features <i class="fa-solid fa-arrow-up"></i>`
    }
}

// Modal
let modalFunc = (element) => {
    const modal = document.getElementById("modal-box")
    const main = document.getElementById("main")
    // const modalBtn = document.getElementById("modal-btn")
    // var span = document.getElementsByClassName("close")[0]

    if (element === "open") {
        modal.style.display = "block"
        main.style.animation = "none"
    } else if (element === "close") {
        main.style.animation = "AnimateGradient 10s ease infinite"
        modal.style.display = "none"
    }
}


// ======================== Login ======================== //
let login = () => {
    let adminPage = "../pages/planning.html"
    let loginCode = prompt("Enter Admin Password");
    if (loginCode != null) {
        if (loginCode == 666) {
            window.location.href = adminPage
        } else {
            alert("This is the incorrect password")
        }
    } else {
        alert("You entered an empty password")
    }
}



// ======================== Window events ======================== //
// active status on menu items
window.addEventListener('load', () => {
    // Side nav active status on page load
    const homeLink = document.getElementById("home-link")
    const aboutLink = document.getElementById("about-link")
    const contactLink = document.getElementById("contact-link")
    const experimentsLink = document.getElementById("experiments-link")
    const home = "/index.html"
    const about = "/pages/about.html"
    const contact = "/pages/contact.html"
    const experiments = "/pages/test.html"
    let navLinks = [homeLink, aboutLink, contactLink, experimentsLink]
    let navUrls = [home, about, contact, experiments]
    let j = 0

    for (let i = 0; i < navUrls.length; i++) {

        if (navUrls[i] === window.location.pathname) {
            navLinks[j].classList.add("active")
        } else {
            navLinks[j].classList.remove("active")
        }
        j += 1
    }
});

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    let modal = document.getElementById("modal-box")
    let main = document.getElementById("main")
    if (event.target == modal) {
        modal.style.display = "none"
        main.style.animation = "AnimateGradient 10s ease infinite"
    }
}
