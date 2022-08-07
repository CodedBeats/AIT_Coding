// ======================== Nav ======================== //
const sideNav = document.getElementById("dom-side-nav")
const main = document.getElementById("main")

// Toggle Nav func
let openNav = () => {
    if (sideNav.style.display === "none") {
        sideNav.style.display = "block"
        
        // phone view adjustments 
        if (window.screen.width <= 620) {
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
