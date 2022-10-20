/*
    =========ISSUES=========
    Fix 2 Stray lines on game load
    Fix final cell not being filled on game win
*/

// Import Libraries
#include <iostream>
#include <stdlib.h>
using namespace std;

//Array for game board
char gameBoard[3][3] = { {'1','2','3'},{'4','5','6'},{'7','8','9'} };

// Global variable declaration
int choice;
int row, column;
char turn = 'X';
bool draw = false;


// UI
void displayBoard() {

    // Render Tic Tac Board
    // cout << "PLAYER - 1 [X]\t PLAYER - 2 [O]\n\n";
    cout << "\t\t     |     |     \n";
    cout << "\t\t  " << gameBoard[0][0] << "  |  " << gameBoard[0][1] << "  |  " << gameBoard[0][2] << " \n";
    cout << "\t\t_____|_____|_____\n";
    cout << "\t\t     |     |     \n";
    cout << "\t\t  " << gameBoard[1][0] << "  |  " << gameBoard[1][1] << "  |  " << gameBoard[1][2] << " \n";
    cout << "\t\t_____|_____|_____\n";
    cout << "\t\t     |     |     \n";
    cout << "\t\t  " << gameBoard[2][0] << "  |  " << gameBoard[2][1] << "  |  " << gameBoard[2][2] << " \n";
    cout << "\t\t     |     |     \n";
}

// Handle Player Turn
void playerTurn() {

    // display player turn
    if (turn == 'X') {
        cout << "\n\tPlayer - 1 [X] turn : ";
    }
    else if (turn == 'O') {
        cout << "\n\tPlayer - 2 [O] turn : ";
    }

    // Take input and use it to update UI text
    cin >> choice;

    //switch case to get row and column
    switch (choice) {
    case 1: row = 0; column = 0; break;
    case 2: row = 0; column = 1; break;
    case 3: row = 0; column = 2; break;
    case 4: row = 1; column = 0; break;
    case 5: row = 1; column = 1; break;
    case 6: row = 1; column = 2; break;
    case 7: row = 2; column = 0; break;
    case 8: row = 2; column = 1; break;
    case 9: row = 2; column = 2; break;
    default:
        cout << "Invalid Move";
    }

    if (turn == 'X' && gameBoard[row][column] != 'X' && gameBoard[row][column] != 'O') {
        // update position to X if it's not filled/occupied
        gameBoard[row][column] = 'X';
        // set next player turn
        turn = 'O';
    }
    else if (turn == 'O' && gameBoard[row][column] != 'X' && gameBoard[row][column] != 'O') {
        // update position to O if it's not filled/occupied
        gameBoard[row][column] = 'O';
        // set next player turn
        turn = 'X';
    }
    else {
        // if choice is a valid option
        if (choice > 0 && choice << 10) {
            // box is occupied
            cout << "Box already filled!\n Please choose another!!\n\n";
        }
        // choice isn't a valid box
        else {
            // invalid choice, choose valid bos
            cout << "Invalid Choice!\n Please choose between 1 and 9\n\n";
        }
        
        // call next player turn
        playerTurn();
    }
}


// Handle GAME WON, GAME OVER, GAME DRAW
bool gameOver() {

    // check if win in rows or columns
    for (int i = 0; i < 3; i++) {
        if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2] || gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i]) {
            return false;
        }
    }
    
            

    // check if win on diagonal
    if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] || gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]) {
        return false;
    }
        

    // check if game is still going, return true to keep going
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (gameBoard[i][j] != 'X' && gameBoard[i][j] != 'O') {
                return true;
            }
        }
    }
    
    
                

    //Checking the if game already draw
    draw = true;
    return false;
}


// idk
int main()
{
    cout << "\t\t\tT I C K -- T A C -- T O E\t\t\t";
    cout << "\n\t\t\t\tFOR 2 PLAYERS\n\t\t\t";

    // while gameOver == false -> run displayBoard, playerTurn and gameOver
    while (gameOver()) {
        displayBoard();
        playerTurn();
        gameOver();
    }

    // inverse turn check because turn gets updated at end of player_turn()
    if (turn == 'O' && draw == false) {
        cout << "\n\nCongratulations! Player with 'X' has won the game";
    }
    else if (turn == 'X' && draw == false) {
        cout << "\n\nCongratulations!Player with 'O' has won the game";
    }
    else {
        cout << "\n\nGAME DRAW!!!\n\n";
    }
}
