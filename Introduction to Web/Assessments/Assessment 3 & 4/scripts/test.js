// Change text position
let changePos = () => {
    let element = document.getElementById("swap")
    element.style.textAlign = element.style.textAlign === 'end' ? '' : 'end'

    let btn = document.getElementById("swap-btn")
    if (btn.value == "Javascript Experiments ->") btn.value = "<- Javascript Experiments"
    else btn.value = "Javascript Experiments ->"
}


// Add class to text
let addClass = () => {
    let element = document.getElementById("test1")
    element.classList.toggle("i-added-a-class");
    console.log("test xx")
}


// Hide div 
let visible = () => {
    const div = document.getElementById("test2")
    if (div.style.display === "none") {
        div.style.display = "block"
    } else {
        div.style.display = "none"
    }
}



// Show different text box
let changeDisplay = (page) => {
    if (page === "displayed-text1") {
        document.getElementById("displayed-text1").style.display = "block"
        document.getElementById("displayed-text2").style.display = "none"
        document.getElementById("displayed-text3").style.display = "none"
    } else if (page === "displayed-text2") {
        document.getElementById("displayed-text1").style.display = "none"
        document.getElementById("displayed-text2").style.display = "block"
        document.getElementById("displayed-text3").style.display = "none"
    } else if (page === "displayed-text3") {
        document.getElementById("displayed-text1").style.display = "none"
        document.getElementById("displayed-text2").style.display = "none"
        document.getElementById("displayed-text3").style.display = "block"
    }
}
