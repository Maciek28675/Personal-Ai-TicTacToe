package view;

import model.Board;
import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private JButton[][] GameBoard;
    private Board board;

    private static final Color BACKGROUND_COLOR = new Color(23, 19, 33);
    private static final Color BOARD_COLOR = new Color(73, 73, 73);
    private static final Color GRID_COLOR = new Color(255, 255, 255);

    private static final int SQUARE_SIZE = 150;

    public BoardPanel(Board board) {
        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.board = board;

        initComponents();
        setUpLayout();
    }

    // ==========================
    // Getters and Setters
    // ==========================

    public JButton getBoardButton(int row, int col){
        return GameBoard[row][col];
    }

    // ==============================
    // Constructor related methods
    // ==============================

    private void initComponents() {
        GameBoard = new JButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                GameBoard[row][col] = new JButton();
                GameBoard[row][col].setBackground(BOARD_COLOR);
                GameBoard[row][col].setFont(new Font("Arial", Font.PLAIN, 150));
                GameBoard[row][col].setForeground(Color.WHITE);
                GameBoard[row][col].setBorder(BorderFactory.createLineBorder(GRID_COLOR, 2));
                GameBoard[row][col].setFocusable(false);
                GameBoard[row][col].setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                GameBoard[row][col].setMaximumSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                GameBoard[row][col].setMinimumSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                GameBoard[row][col].setEnabled(false);
            }
        }
    }

    private void setUpLayout() {
        this.setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.add(GameBoard[row][col]);
            }
        }
    }

    // ==============================
    // Other methods
    // ==============================

    public void updateSquare(int row, int col, char figure) {
        GameBoard[row][col].setText(figure + "");
    }

    public void highlightWinningSquare() {
        for(int row = 0; row < 3; row++){
            for(int col = 0; col<3; col++){
                if(board.getWinningCell(row,col)){
                    GameBoard[row][col].setForeground(new Color(130, 227, 74));
                }
            }
        }

    }
}
