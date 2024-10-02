package view;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private JButton[][] board;

    private static final Color BACKGROUND_COLOR = new Color(23, 19, 33);
    private static final Color BOARD_COLOR = new Color(73, 73, 73);
    private static final Color GRID_COLOR = new Color(255, 255, 255);

    private static final int SQUARE_SIZE = 150;

    public BoardPanel() {
        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        initComponents();
        setUpLayout();
    }

    // ==========================
    // Getters and Setters
    // ==========================

    public JButton getBoardButton(int row, int col){
        return board[row][col];
    }

    // ==============================
    // Constructor related methods
    // ==============================

    private void initComponents() {
        board = new JButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new JButton();
                board[row][col].setBackground(BOARD_COLOR);
                board[row][col].setFont(new Font("Arial", Font.BOLD, 30));
                board[row][col].setBorder(BorderFactory.createLineBorder(GRID_COLOR, 2));
                board[row][col].setFocusable(false);
                board[row][col].setPreferredSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                board[row][col].setMaximumSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                board[row][col].setMinimumSize(new Dimension(SQUARE_SIZE, SQUARE_SIZE));
                board[row][col].setEnabled(false);
            }
        }
    }

    private void setUpLayout() {
        this.setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.add(board[row][col]);
            }
        }
    }
}
