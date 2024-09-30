package view;
import model.Board;

import javax.swing.*;
import java.awt.*;

// This class is used to configure main window properties,
// initialize components and place them in the window
public class MainFrame extends JFrame {

    private MenuPanel menuPanel;
    //private JPanel gameBoard;

    public MainFrame() {

        this.setTitle("Tic Tac Toe 1.0");
        this.setSize(500, 750);
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
    }

    // This method is used to place every gui element in a windows
    private void setUpLayout() {

        this.setLayout(new BorderLayout());
        this.add(menuPanel, BorderLayout.NORTH);
    }
}