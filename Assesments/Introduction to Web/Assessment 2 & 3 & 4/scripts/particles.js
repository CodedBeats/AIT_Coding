// initialize canvas
const canvas = document.getElementById("canvas1")
const ctx = canvas.getContext("2d")
ctx.canvas.width  = window.innerWidth
ctx.canvas.height = window.innerHeight
let particleArr = []

// create constructor function
function Particle(x, y, directionX, directionY, size, color) {
    this.x = x
    this.y = y
    this.directionX = directionX
    this.directionY = directionY
    this.size = size
    this.color = color
}

// add draw method to particle prototype
Particle.prototype.draw = function() {
    ctx.beginPath()
    ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2, false)
    ctx.fillStyle = this.color
    ctx.fill()
}

// add update method to particle prototype
Particle.prototype.update = function() {
    // check if particle has reached end of the screen (x axis)
    if(this.x + this.size > canvas.width || this.x - this.size < 0) {
        // if true, switch its direction
        this.directionX = -this.directionX
    }
    // check if particle has reached end of the screen (y axis)
    if(this.y + this.size > canvas.width || this.y - this.size < 0) {
        // if true, switch its direction
        this.directionY = -this.directionY
    }
    //update particle position by adding directionX and directionY to x and y coordinates
    this.x += this.directionX
    this.y += this.directionY

    this.draw()
}

// create particle arrays 
function init() {
    particleArr = []
    for (let i = 0; i < 100; i++) {
        let size = Math.random() * 20
        let x = Math.random() * (innerWidth - size * 2)
        let y = Math.random() * (innerHeight - size * 2)
        // make particles move slowly so it looks more like they're floating
        let directionX = (Math.random() * .4) - .2
        let directionY = (Math.random() * .4) - .2
        // asign random colors
        const colors = ["red", "green", "blue"]
        let randomColor = Math.floor(Math.random() * colors.length)
        let color = `${colors[randomColor]}`

        // push 100 particles into the array
        particleArr.push(new Particle(x, y, directionX, directionY, size, color))
    }
}

// particle animation loop
function animation() {
    requestAnimationFrame(animation)
    // clear canvas so its ready for next update to draw
    ctx.clearRect(0, 0, innerWidth, innerHeight)

    // iterate through particle array and run update for each particle
    for (let i = 0; i < particleArr.length; i++) {
        particleArr[i].update()
    }
}

// call the initialize function to set up particles
init()
// call the animation function to animate particles
animation()

// if window size is changed, nothing breaks
window.addEventListener("resize",
    function() {
        canvas.width = innerWidth
        canvas.height = innerHeight
        init()
    }
)
