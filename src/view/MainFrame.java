package view;

import javax.swing.*;
import java.awt.*;

// This class is used to configure main window properties,
// initialize components and place them in the window
public class MainFrame extends JFrame {

    private MenuPanel menuPanel;
    private BoardPanel boardPanel;
    //private JPanel gameBoard;

    public MainFrame() {

        this.setTitle("Tic Tac Toe 1.0");
        this.setSize(550, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(23,19,33));

        initComponents();
        setUpLayout();

        this.setVisible(true);
    }

    // This method is used to configure all component properties like fonts, color, etc.
    private void initComponents() {
        // Panels
        menuPanel = new MenuPanel();
        boardPanel = new BoardPanel();
    }

    // This method is used to place every gui element in a windows
    private void setUpLayout() {

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        boardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(menuPanel);
        this.add(boardPanel);
    }
}
