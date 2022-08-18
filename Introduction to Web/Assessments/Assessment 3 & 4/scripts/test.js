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


// Active item on click 
let active = (ref) => {
    const div1 = document.getElementById("active1")
    const div2 = document.getElementById("active2")
    const div3 = document.getElementById("active3")
    let arr = [div1, div2, div3]
    
    for (let i = 0; i < arr.length; i++) {
        if (arr[i].id === ref) {
            arr[i].classList.add("active-text2")
        } else {
            arr[i].classList.remove("active-text2")
        }
    }
}


// Loading Page DOM
let onReady = (func) => {
    let intervalTime = window.setInterval(checkReady, 5000);

    function checkReady() {
        if (document.getElementsByTagName('body')[0] !== undefined) {
            window.clearInterval(intervalTime);
            func.call(this);
        }
    }
}

let show = (id, value) => {
    document.getElementById(id).style.display = value ? 'block' : 'none';
}

onReady(() => {
    show('loaded-page', true);
    show('loading-page', false);
});

