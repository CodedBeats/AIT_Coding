// initialize canvas
const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")
ctx.canvas.width  = window.innerWidth
ctx.canvas.height = window.innerHeight
let laserArr = []


let lineLength = 100
let x1 = canvas.width
let y1 = (Math.random() * canvas.height) - 60
let speedX = -20
let speedY = 20

const angle = 90
// Math.floor(Math.random() * 180)
x2 = x1 + Math.cos((Math.PI / 180.0) * angle - Math.floor(Math.random() * 180)) * lineLength
y2 = y1 + Math.sin((Math.PI / 180.0) * angle - Math.floor(Math.random() * 180)) * lineLength

function draw() {
    ctx.beginPath()
    ctx.moveTo(x1, y1 );
    ctx.lineTo(x2, y2 + lineLength);
    ctx.lineWidth = 8
    ctx.lineCap = "round"
    ctx.stroke()
    ctx.shadowColor = "red"
    ctx.shadowBlur = 20
    ctx.strokeStyle = "rgb(255, 0, 0)"
    ctx.stroke()
}



function pewpew() {
    x1 += speedX
    y1 += speedY

    x2 += speedX
    y2 += speedY
  
    // if (x < 0 || x > canvas.height) {
	//     speed = speed * -1;
    // }
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
        init()
    }
)
