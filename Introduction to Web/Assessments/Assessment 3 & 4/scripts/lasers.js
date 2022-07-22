// initialize canvas
const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")
ctx.canvas.width  = window.innerWidth
ctx.canvas.height = window.innerHeight
let laserArr = []


let lineLength = 0
let x1 = canvas.width
let x2 = canvas.width - lineLength
let y1 = (Math.random() * canvas.height)
// let y1 = 180
let speedX = -40
let speedY = 0

// === angled Lasers ===
// const angle = 180
// const r = angle * (Math.PI/180)
// x2 = x1 + Math.cos(r) * lineLength
// y2 = y1 + Math.sin(r) * lineLength


function draw() {
    ctx.beginPath()
    ctx.moveTo(x1, y1)
    // angled Lasers
    // ctx.lineTo(x2, y2 + lineLength)
    ctx.lineTo(x2, y1)
    ctx.lineWidth = 15
    ctx.lineCap = "round"
    ctx.stroke()
    ctx.shadowColor = "red"
    ctx.shadowBlur = 20
    ctx.strokeStyle = "rgb(255, 0, 0)"
    ctx.stroke()
}
// console.log(`X1 is: ${x1}, Y1 is: ${y1}, X2 is: ${x2}, Y2 is: ${y2}`)
console.log(`X1 is: ${x1}, Y1 is: ${y1}`)



function pewpew() {
    x1 += speedX

    function xSpeed() {x2 += speedX}
    setTimeout(xSpeed, 50)

    // angled Lasers
    // x2 += speedX
    // y2 += speedY
}

function loopAnimation() {
	// clear old frame;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    pewpew();
    draw();
    requestAnimationFrame(loopAnimation);
}
requestAnimationFrame(loopAnimation);

// if window size is changed, nothing breaks
window.addEventListener("resize",
    function() {
        canvas.width = innerWidth
        canvas.height = innerHeight
        // init()
    }
)
