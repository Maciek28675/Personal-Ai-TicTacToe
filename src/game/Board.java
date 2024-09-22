package game;

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

    public boolean makeMove(int row, int col) {
        return false;
    }

    public boolean isGameFinished() {
        return false;
    }

    public char checkGameState() {
        return '0';
    }

    public void resetBoard() {

    }

    public int emptyCells(){
        return 0;
    }


}
