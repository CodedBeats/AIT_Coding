const canvas = document.getElementById("gameCanvas");
const ctx = canvas.getContext("2d");

// class for the segments of the snake and it's constructor
class snakeSegment{
    constructor(x, y){
        this.x = x;
        this.y = y;
    }
}

// Game variables
let speed = 5;

let tileCount = 30;
let tileSize = canvas.width / tileCount - 5;

let canvasHeight = canvas.height / tileCount
let canvasWidth = canvas.width / tileCount

let snakeHeadX = 10;
let snakeHeadY = 10;

const snakeSegments = [];
let snakeLength = 2;

let foodX = 5;
let foodY = 5;

let xVelocity = 0;
let yVelocity = 0;

let score = 0;
let rank = '';

// Audio variables
const point = new Audio("../games/snake/smb_coin.wav");
const rankUp = new Audio("../games/snake/smb_stage_clear.wav");
const collideWithSelf = new Audio("../games/snake/smb_mariodie.wav");
const collideWithWall = new Audio("../games/snake/smb_gameover.wav");
const closeToWinning = new Audio("../games/snake/smb_warning.wav");
const Win = new Audio("../games/snake/smb_world_clear.wav");

// functions for calling the senquence of all other functions
function game(){
    snakePosition();
    let result = isGameOver();
    if(result == true){
        return;
    }
    // console.log(snakeHeadX, snakeHeadY)

    clearBoard();
    checkFoodCollision();
    drawfood();
    drawSnake();
    drawScoreAndRank();
    changeSpeed();
    setTimeout(game, 1000/speed);
}

// detemines the position of the head of the snake
function snakePosition(){
    snakeHeadX = snakeHeadX + xVelocity;
    snakeHeadY = snakeHeadY + yVelocity;
}

// checks for all lose & win conditions
function isGameOver(){
    let gameOver = false;

    if (xVelocity == 0 && yVelocity == 0){
        return false;
    }

    if (snakeHeadX < 0 || snakeHeadY < 0){
        collideWithWall.play();
        gameOver = true;
    }
    else if(snakeHeadX == Math.floor(canvasWidth) || snakeHeadY == Math.floor(canvasHeight)){
        collideWithWall.play();
        gameOver = true;
    }
    for(let i = 0; i < snakeSegments.length; i++){
        let segment = snakeSegments[i];
        if (segment.x == snakeHeadX && segment.y == snakeHeadY){
            gameOver = true;
            collideWithSelf.play();
            break;
        }
    }
    if (score == 150){
        updateHighScore();
        Win.play();
        gameOver = true;
    }
    if (gameOver == true){
        // update high score after game ends
        updateHighScore();

        ctx.fillStyle = "#ffffff";
        ctx.font = "bold 100px Arial"
        ctx.fillText("Game Over!", canvas.width / 6, canvas.height / 1.9)
        switch (rank){
            case 'Dirt':
                ctx.fillStyle = "#9b7653"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 4, canvas.height / 1.6)
                break;
            case 'Wooden': 
                ctx.fillStyle = "#A1662F"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 5, canvas.height / 1.6)
                break;
            case 'Iron': 
                ctx.fillStyle = "#a19d94"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 4, canvas.height / 1.6)
                break;
            case 'Bronze':
                ctx.fillStyle = "#CD7F32" 
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 5, canvas.height / 1.6)
                break;
            case 'Silver': 
                ctx.fillStyle = " #C0C0C0"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 5, canvas.height / 1.6)
                break;
            case 'Gold': 
                ctx.fillStyle = "#ffd700"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 4, canvas.height / 1.6)
                break;
            case 'Platinum': 
                ctx.fillStyle = " #E5E4E2"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 5, canvas.height / 1.6)
                break;
            case 'Platinum+':
                ctx.fillStyle = " #E5E4E2"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 6, canvas.height / 1.6)
                break;
            case 'Platinum++':
                ctx.fillStyle = " #E5E4E2"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your rank is " + rank, canvas.width / 6, canvas.height / 1.6)
                ctx.fillText("Uh wow...", canvas.width / 3, canvas.height / 1.4)
                ctx.fillText("So I guess you got good", canvas.width / 6, canvas.height / 1.3)
                break;
            default:
                ctx.fillStyle = "#ffffff"
                ctx.font = "bold 50px Arial"
                ctx.fillText("Your are unrankable", canvas.width / 4, canvas.height / 1.6)
        }
    }
    return gameOver;
}

// Updates the game board
function clearBoard(){
    ctx.fillStyle = "black";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
}

// chechs if snakes has collided with and update length & score accordingly
function checkFoodCollision(){
    if (foodX == snakeHeadX && foodY == snakeHeadY){
        foodX = Math.floor(Math.random() * canvasWidth);
        foodY = Math.floor(Math.random() * canvasHeight);
        snakeLength ++;
        score ++;
        point.play();
    }
}

// creates and randomises the placement of food
function drawfood(){
    ctx.fillStyle = "#7851a9";
    ctx.fillRect(foodX*tileCount, foodY*tileCount, tileCount - 5, tileCount - 5)
}

// draws the snake sprite and updates length
function drawSnake(){
    ctx.fillStyle = "#4169E1";
    for(let i = 0; i < snakeSegments.length; i++){
        let segment = snakeSegments[i];
        ctx.fillRect(segment.x *tileCount, segment.y*tileCount, tileSize, tileSize);
    }

    snakeSegments.push(new snakeSegment(snakeHeadX, snakeHeadY));
    if (snakeSegments.length > snakeLength){
        snakeSegments.shift();
    }

    ctx.fillStyle = "#FFD700";
    ctx.fillRect(snakeHeadX*tileCount, snakeHeadY*tileCount, tileSize, tileSize);
}

// updates Score board Score & corresponding rank/colour
function drawScoreAndRank(){
        ctx.fillStyle = "#ffffff"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
    if (score > 0 && score <= 5){
        rank = 'Dirt'
        ctx.fillStyle = "#9b7653"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
    }
    else if (score > 5 && score <= 10){
        rank = 'Wooden'
        ctx.fillStyle = "#A1662F"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
        if (score == 6){
            rankUp.play();
        }
    }
    else if (score > 10 && score <= 25){
        rank = 'Iron'
        ctx.fillStyle = "#a19d94"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
        if (score == 11){
            rankUp.play();
        }
    }
    else if (score > 25 && score <= 50){
        rank = 'Bronze'
        ctx.fillStyle = "#CD7F32"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
        if (score == 26){
            rankUp.play();
        }
    }
    else if (score > 50 && score <= 75){
        rank = 'Silver'
        ctx.fillStyle = " #C0C0C0"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
        if (score == 51){
            rankUp.play();
        }
    }
    else if (score > 75 && score <= 100){
        rank = 'Gold'
        ctx.fillStyle = "#ffd700"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
        if (score == 76){
            rankUp.play();
        }
    }
    else if (score > 100 && score <= 125){
        rank = 'Platinum'
        ctx.fillStyle = " #E5E4E2"
        ctx.font = "bold 15px Arial"
        ctx.fillText("Score: " + score, canvas.width -80, 15)
        if (score == 101){
            rankUp.play();
        }
    }
    else if (score > 125 && score < 150){
        rank = 'Platinum+'
        if(score == 126){
            closeToWinning.play();
        }
    }
    else if (score == 150){
        rank = 'Platinum++'
    }
}

// change how fast the snake moves
function changeSpeed(){
    if (score >= 5){
        speed = 6
    }
    if (score >= 10){
        speed = 8
    }
    if (score >= 25){
        speed = 10
    }
    if (score >= 50){
        speed = 12
    }
    if (score >= 75){
        speed = 16
    }
    if (score >= 100){
        speed = 20
    }
    if (score >= 125){
        speed = 26
    }
}

// checks of arrow key inputs
document.body.addEventListener("keydown", KeyPressedDown)

function KeyPressedDown(event){
    //UP Arrow
    if(event.keyCode == 38){
        if(yVelocity == 1){
            return;
        }
        xVelocity = 0;
        yVelocity = -1;
    }
    //DOWN Arrow
    if(event.keyCode == 40){
        if(yVelocity == -1){
            return;
        }
        xVelocity = 0;
        yVelocity = 1;
    }
    //LEFT Arrow
    if(event.keyCode == 37){
        if(xVelocity == 1){
            return;
        }
        xVelocity = -1;
        yVelocity = 0;
    }
    //RIGHT Arrow
    if(event.keyCode == 39){
        if(xVelocity == -1){
            return;
        }
        xVelocity = 1;
        yVelocity = 0;
    }
}

// runs Game
game();


///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Flag to track if the game is running
let isGameRunning = false;

// Function to reset the game
function resetGame() {
    if (isGameRunning) {
        return; // Don't reset if the game is already running
    }

    // get update session highscore
    const highscoreText = document.getElementById("session-highscore");
    highscoreText.textContent = "";

    // Set the flag to indicate the game is running
    isGameRunning = true;

    // Reset all game variables to their initial values
    speed = 5;
    tileCount = 30;
    tileSize = canvas.width / tileCount - 5;
    // ... Reset other variables ...

    // Clear the canvas
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Reset the snake position and other game-related variables
    snakeHeadX = 10;
    snakeHeadY = 10;
    snakeSegments.length = 0;
    snakeLength = 2;
    foodX = 5;
    foodY = 5;
    xVelocity = 0;
    yVelocity = 0;
    score = 0;
    rank = '';

    // Call the game function to start a new game
    game();

    // Reset the flag after a short delay to allow the game to start
    setTimeout(() => {
        isGameRunning = false;
    }, 100);
}

function updateHighScore() {
    // get score element
    const highscoreText = document.getElementById("session-highscore");

    // update score
    highscoreText.textContent = score;
    
}

// add functionality to restart btn
const resetButton = document.getElementById("restart-game");
resetButton.addEventListener("click", resetGame);
