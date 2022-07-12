const div = document.getElementById("div")

let visible = () => {
    if (div.style.display === "none") {
        div.style.display = "block"
    } else {
        div.style.display = "none"
    }
}