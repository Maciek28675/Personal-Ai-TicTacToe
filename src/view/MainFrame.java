package view;

import controller.*;
import model.*;

import javax.swing.*;
import java.awt.*;

// This class is used to configure main window properties,
// initialize components and place them in the window
public class MainFrame extends JFrame {

    private MenuPanel menuPanel;
    private BoardPanel boardPanel;
    private MenuController menuController;
    private GameController gameController;
    private Board board;
    private MiniMax minimax;

    private static final Color BACKGROUND_COLOR = new Color(23, 19,33);
    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 800;

    public MainFrame() {

        this.setTitle("Tic Tac Toe 1.0");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(BACKGROUND_COLOR);

        initComponents();
        setUpLayout();

        this.setVisible(true);
    }

    // This method is used to configure all component properties like fonts, color, etc.
    private void initComponents() {
        // Models
        board = new Board((byte) 3, (byte) 3);
        minimax = new MiniMax();

        // Panels
        menuPanel = new MenuPanel();
        boardPanel = new BoardPanel(board);

        // Controllers
        gameController = new GameController(boardPanel, menuPanel, board, minimax);
        menuController = new MenuController(menuPanel, gameController, minimax);
    }

    // This method is used to place every gui element in a windows
    private void setUpLayout() {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.add(menuPanel);
        this.add(boardPanel);
    }
}
