package view;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private JButton[][] board;

    public BoardPanel() {
        this.setBackground(new Color(23,19,33));
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));

        initComponents();
        setUpLayout();
    }

    private void initComponents() {
        board = new JButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = new JButton();
                board[row][col].setBackground(new Color(73, 73, 73));
                board[row][col].setFont(new Font("Arial", Font.BOLD, 30));
                board[row][col].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2));
                board[row][col].setFocusable(false);
                board[row][col].setPreferredSize(new Dimension(150, 150));
                board[row][col].setMaximumSize(new Dimension(150, 150));
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
