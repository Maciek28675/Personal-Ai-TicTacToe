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


    MenuPanel() {
        // General panel configuration
        this.setBackground(new Color(23,19,33));

        initComponents();
        setUpLayout();
    }

    private void initComponents(){
        // Labels
        welcomeMessage = new JLabel("Welcome to Ai Tic Tac Toe");
        welcomeMessage.setForeground(new Color(255, 255, 255));
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        difficultyMessage = new JLabel("Choose difficulty");
        difficultyMessage.setForeground(new Color(255, 255, 255));
        difficultyMessage.setFont(new Font("Arial", Font.BOLD, 20));
        difficultyMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        turnInfo = new JLabel("Your turn!");
        turnInfo.setForeground(new Color(255, 255, 255));
        turnInfo.setFont(new Font("Arial", Font.BOLD, 20));
        turnInfo.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Buttons
        newGameButton = new JButton("START");
        newGameButton.setBackground(new Color(68, 147, 65));
        newGameButton.setForeground(new Color(255, 255, 255));
        newGameButton.setFont(new Font("Arial", Font.BOLD, 30));
        newGameButton.setBorder(BorderFactory.createLineBorder(new Color(47, 107, 45), 3));
        newGameButton.setFocusable(false);
        newGameButton.setPreferredSize(new Dimension(200, 60));
        newGameButton.setMaximumSize(new Dimension(200, 60));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Sliders
        difficultySlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
        difficultySlider.setBackground(new Color(23,19,33));
        difficultySlider.setForeground(new Color(255, 255, 255));
        difficultySlider.setFont(new Font("Arial", Font.BOLD, 15));
        difficultySlider.setPaintTicks(true);
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintLabels(true);
        difficultySlider.setPreferredSize(new Dimension(100, 50));
        difficultySlider.setMaximumSize(new Dimension(200, 50));
        difficultySlider.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void setUpLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(Box.createVerticalStrut(20));
        this.add(welcomeMessage);
        this.add(Box.createVerticalStrut(20));
        this.add(difficultyMessage);
        this.add(Box.createVerticalStrut(20));
        this.add(difficultySlider);
        this.add(Box.createVerticalStrut(20));
        this.add(newGameButton);
        this.add(Box.createVerticalStrut(20));
        this.add(turnInfo);
    }

}
