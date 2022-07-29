// === Test Functions === //


// Change text position
let changePos = () => {
    let element = document.getElementById("swap")
    element.style.textAlign = element.style.textAlign === 'end' ? '' : 'end'

    let btn = document.getElementById("swap-btn")
    if (btn.value == "Testing New Features To Add >") btn.value = "< Testing New Features To Add"
    else btn.value = "Testing New Features To Add >"
}


// Add class to text
function addClass() {
    let element = document.getElementById("test1")
    element.classList.toggle("i-added-a-class");
    console.log("test xx")
}


// Hide div 
const div = document.getElementById("test2")

let visible = () => {
    if (div.style.display === "none") {
        div.style.display = "block"
    } else {
        div.style.display = "none"
    }
}
