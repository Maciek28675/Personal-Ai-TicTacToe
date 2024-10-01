package view;

import javax.swing.*;
import java.awt.*;

// This class is used to configure all visual components related
// to menu options like buttons for starting a new game or
// choosing Ai difficulty.
// Logic however is in the controller package
public class MenuPanel extends JPanel {
    private JLabel welcomeMessage;
    private JLabel difficultyMessage;
    private JLabel turnInfo;
    private JButton newGameButton;
    private JSlider difficultySlider;

    private static final Color BACKGROUND_COLOR = new Color(23, 19, 33);
    private static final Color TEXT_COLOR = new Color(255, 255, 255);
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(68, 147, 65);
    private static final Color BUTTON_BORDER_COLOR = new Color(47, 107, 45);

    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
    private static final int SLIDER_WIDTH = 200;
    private static final int SLIDER_HEIGHT = 50;


    MenuPanel() {
        // General panel configuration
        this.setBackground(BACKGROUND_COLOR);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        initComponents();
        setUpLayout();
    }

    private void initComponents(){
        // Labels
        welcomeMessage = new JLabel("Welcome to Ai Tic Tac Toe");
        welcomeMessage.setForeground(TEXT_COLOR);
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        difficultyMessage = new JLabel("Choose difficulty");
        difficultyMessage.setForeground(TEXT_COLOR);
        difficultyMessage.setFont(new Font("Arial", Font.BOLD, 20));
        difficultyMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        turnInfo = new JLabel("Your turn!");
        turnInfo.setForeground(TEXT_COLOR);
        turnInfo.setFont(new Font("Arial", Font.BOLD, 20));
        turnInfo.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Buttons
        newGameButton = new JButton("START");
        newGameButton.setBackground(BUTTON_BACKGROUND_COLOR);
        newGameButton.setForeground(TEXT_COLOR);
        newGameButton.setFont(new Font("Arial", Font.BOLD, 30));
        newGameButton.setBorder(BorderFactory.createLineBorder(BUTTON_BORDER_COLOR, 3));
        newGameButton.setFocusable(false);
        newGameButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        newGameButton.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Sliders
        difficultySlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
        difficultySlider.setBackground(BACKGROUND_COLOR);
        difficultySlider.setForeground(TEXT_COLOR);
        difficultySlider.setFont(new Font("Arial", Font.BOLD, 15));
        difficultySlider.setPaintTicks(true);
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintLabels(true);
        difficultySlider.setPreferredSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
        difficultySlider.setMaximumSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
        difficultySlider.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void setUpLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(20));
        this.add(welcomeMessage);
        this.add(Box.createVerticalStrut(20));
        this.add(difficultyMessage);
        this.add(Box.createVerticalStrut(10));
        this.add(difficultySlider);
        this.add(Box.createVerticalStrut(20));
        this.add(newGameButton);
        this.add(Box.createVerticalStrut(20));
        this.add(turnInfo);
    }

}
