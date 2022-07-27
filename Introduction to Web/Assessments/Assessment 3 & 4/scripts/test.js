// === Test Functions === //


// Add class function
function addClass() {
    let element = document.getElementById("test1")
    element.classList.toggle("i-added-a-class");
    console.log("test xx")
}


// Hide div example
const div = document.getElementById("test2")

let visible = () => {
    if (div.style.display === "none") {
        div.style.display = "block"
    } else {
        div.style.display = "none"
    }
}
