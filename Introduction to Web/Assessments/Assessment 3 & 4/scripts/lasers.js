ethereum.autoRefreshOnNetworkChange = false
// initialize canvas
const canvas = document.getElementById("canvas")
const ctx = canvas.getContext("2d")
ctx.canvas.width  = window.innerWidth
ctx.canvas.height = window.innerHeight
let laserArr = []



// constructor function for Laser object
function Laser(x1, x2, y, speedX, speedY, lineWidth, lineCap,shadowBlur, shadowColor, strokeStyle) {
    this.x1 = x1
    this.x2 = x2
    this.y = y
    this.speedX = speedX
    this.speedY = speedY
    this.lineWidth = lineWidth
    this.lineCap = lineCap
    this.shadowColor = shadowColor
    this.shadowBlur = shadowBlur
    this.strokeStyle = strokeStyle
}


// add properties to Laser in draw() function
Laser.prototype.draw = function() {
    ctx.beginPath()
    ctx.moveTo(this.x1, this.y)
    ctx.lineTo(this.x2, this.y)
    ctx.lineWidth = this.lineWidth
    ctx.lineCap = this.lineCap
    ctx.shadowColor = this.shadowColor
    ctx.shadowBlur = this.shadowBlur
    ctx.strokeStyle = this.strokeStyle
    ctx.stroke()
}



// create array of Lasers
function lasers() {
    laserArr = []

    for (let i = 0; i < 10; i++) {

        // set Laser position and speed
        let x1 = canvas.width
        let x2 = canvas.width
        let y = (Math.random() * canvas.height)
        let speedX = -40
        let speedY = 0

        // set Laser line properties
        let lineWidth = 15
        let lineCap = "round"
        let shadowColor = "red"
        let shadowBlur = 20
        let strokeStyle = "rgb(255, 0, 0)"

        laserArr.push(new Laser(x1, x2, y, speedX, speedY, lineWidth, lineCap, shadowColor, shadowBlur, strokeStyle))
    }
    console.log(laserArr)
}


// make lasers go pewpew
function pewpew() {
    // iterate through laser array
    for (let i = 0; i < laserArr.length; i++) {
        laserArr[i].draw()                                          // draw sigle point laser
        laserArr[i].x1 += laserArr[i].speedX                        // start drawing right
        function xSpeed() {laserArr[i].x2 += laserArr[i].speedX}    // function for setTimeout
        setTimeout(xSpeed, 50)  
    }
}




function loopAnimation() {
    requestAnimationFrame(loopAnimation)
    // clear canvas so its ready for next update to draw
    ctx.clearRect(0, 0, canvas.width, canvas.height)
    
    pewpew()
}
lasers()
requestAnimationFrame(loopAnimation)

// if window size is changed, nothing breaks
window.addEventListener("resize",
    function() {
        canvas.width = innerWidth
        canvas.height = innerHeight
        lasers()
    }
)
