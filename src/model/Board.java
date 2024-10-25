package model;

public class Board {

    private byte size = 3;
    private byte numberToWin = 3;
    private char currentPlayer = 'x';
    private char gameState = 'u';
    public static final int CELLSIZE = 200;

    char [][] board;

    // This array is used to track winning cells so that we know which cells
    // should be marked with different color in case of a win
    private boolean [][] winningCells;

    public Board(byte size, byte numberToWin) {
        this.size = size;
        this.numberToWin = numberToWin;

        this.board = new char[this.size][this.size];
        this.winningCells = new boolean[this.size][this.size];

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                board[i][j] = '0';
            }
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char getGameState() {
        return gameState;
    }

    public boolean getWinningCell(int row, int col) {
        return winningCells[row][col];
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setGameState(char gameState) {
        this.gameState = gameState;
    }

    public void changePlayer(){

        if (currentPlayer == 'x')
            currentPlayer = 'o';

        else if (currentPlayer == 'o')
            currentPlayer = 'x';

    }
    public boolean makeMove(int row, int col, char player){

        // Place figure only on empty squares
        if(board[row][col] != '0')
            return false;

        board[row][col] = player;

        return true;
    }

    // This method is used when we just want to check if any move is available
    // but don't need to check for win or draw
    public boolean isGameFinished() {

        for(int row = 0; row < this.size; row++)
            for(int col = 0; col < this.size; col++)
                if(board[row][col] == '0')
                    return false;

        return true;
    }

    public char checkGameState() {
        byte xScoreCounter = 0;
        byte oScoreCounter = 0;
        resetWinningCells();

        // Check rows
        for (int row = 0; row < this.size; row++) {

            for (int col = 0; col < this.size - 1; col++) {

                if (board[row][col] != '0' && board[row][col] == board[row][col+1]) {

                    if (board[row][col] == 'x')
                        xScoreCounter++;

                    else if (board[row][col] == 'o')
                        oScoreCounter++;

                    winningCells[row][col] = true;
                    winningCells[row][col + 1] = true;
                }

                else {
                    xScoreCounter = 0;
                    oScoreCounter = 0;
                    resetWinningCells();
                }

                if (xScoreCounter == numberToWin - 1)
                    return 'x';
                else if (oScoreCounter == numberToWin - 1)
                    return 'o';

            }

            xScoreCounter = 0;
            oScoreCounter = 0;
            resetWinningCells();
        }

        // Check columns
        for (int col = 0; col < this.size; col++) {

            for (int row = 0; row < this.size - 1; row++) {

                if (board[row][col] != '0' && board[row][col] == board[row + 1][col]) {

                    if (board[row][col] == 'x')
                        xScoreCounter++;

                    else if (board[row][col] == 'o')
                        oScoreCounter++;

                    winningCells[row][col] = true;
                    winningCells[row + 1][col] = true;
                }

                else {
                    xScoreCounter = 0;
                    oScoreCounter = 0;
                    resetWinningCells();
                }

                if (xScoreCounter == numberToWin - 1)
                    return 'x';
                else if (oScoreCounter == numberToWin - 1)
                    return 'o';

            }

            xScoreCounter = 0;
            oScoreCounter = 0;
            resetWinningCells();
        }

        // Check diagonals
        // From left to right
        for (int square = 0; square < this.size - 1; square++) {

            if (board[square][square] == board[square+1][square+1]) {

                if(board[square][square] == 'x')
                    xScoreCounter++;

                else if (board[square][square] == 'o')
                    oScoreCounter++;

                winningCells[square][square] = true;
                winningCells[square+1][square+1] = true;
            }

            else {
                xScoreCounter = 0;
                oScoreCounter = 0;
                resetWinningCells();
            }

            if (xScoreCounter == numberToWin - 1)
                return 'x';
            else if (oScoreCounter == numberToWin - 1)
                return 'o';
        }

        xScoreCounter = 0;
        oScoreCounter = 0;
        resetWinningCells();

        // From right to left
        for (int row = this.size - 1, col = 0; row > 0 && col < this.size - 1; row--, col++) {

            if (board[row][col] == board[row-1][col+1]) {

                if(board[row][col] == 'x')
                    xScoreCounter++;

                else if (board[row][col] == 'o')
                    oScoreCounter++;

                winningCells[row][col] = true;
                winningCells[row-1][col+1] = true;
            }

            else {
                xScoreCounter = 0;
                oScoreCounter = 0;
                resetWinningCells();
            }

            if (xScoreCounter == numberToWin - 1)
                return 'x';
            else if (oScoreCounter == numberToWin - 1)
                return 'o';
        }

        // Check if unfinished
        if(!isGameFinished())
            return 'u';

        // If none of the above conditions is met then return draw
        return 'd';

    }

    public void resetBoard() {

        for(int row = 0; row < this.size; row++)
            for(int col = 0; col < this.size; col++)
                board[row][col] = '0';
    }

    public void resetWinningCells() {

        for(int row = 0; row < this.size; row++)
            for(int col = 0; col < this.size; col++)
                winningCells[row][col] = false;
    }

    // Count how many cells are empty
    public int emptyCells(){
        int count = 0;

        for(int row = 0; row < this.size; row++)
            for(int col = 0; col < this.size; col++)
                if(board[row][col] == '0')
                    count++;

        return count;
    }

    public int getSize(){
        return this.size;
    }
}
