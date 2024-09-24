package game;

import java.util.Arrays;

public class Board {

    private byte size = 3;
    private byte numberToWin = 3;
    private static final int CELLSIZE = 200;

    private char [][] board;
    private boolean [][] winningCells;

    Board(byte size, byte numberToWin) {
        this.size = size;
        this.numberToWin = numberToWin;

        int [][] board = new int[this.size][this.size];
        boolean [][] winningCells = new boolean[this.size][this.size];
    }

    public void draw() {

    }

    public boolean makeMove(int row, int col, char player){

        // Place figure only on empty squares
        if(board[row][col] != '0')
            return false;

        board[row][col] = player;

        return true;
    }

    public boolean isGameFinished() {

        for(int row = 0; row < this.size; row++)
            for(int col = 0; col < this.size; col++)
                if(board[row][col] == '0')
                    return false;

        return true;
    }

    public char checkGameState() {
        return '0';
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

    public int emptyCells(){
        int count = 0;

        for(int row = 0; row < this.size; row++)
            for(int col = 0; col < this.size; col++)
                if(board[row][col] == '0')
                    count++;

        return count;
    }


}
