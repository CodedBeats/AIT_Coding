
let openNav = () => {
    // phone view adjustments 
    if (window.screen.width <= 680) {
        console.log("xx")
        document.getElementById("mySidenav").style.width = "100%";
        document.getElementById("main").style.marginLeft = "100%";
        document.body.style.backgroundColor = "rgba(0,0,0,0.2)";
    } else {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
        document.body.style.backgroundColor = "rgba(0,0,0,0.2)";
    }
}


let closeNav = () => {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
    document.body.style.backgroundColor = "white";
}