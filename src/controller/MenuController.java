package controller;

import view.MenuPanel;
import model.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class MenuController {

    private final MenuPanel menuPanel;
    private final GameController gameController;
    private final MiniMax miniMax;

    private final static Color BUTTON_BACKGROUND_COLOR = new Color(238, 79, 79);

    public MenuController(MenuPanel menuPanel, GameController gameController, MiniMax miniMax) {
        this.menuPanel = menuPanel;
        this.gameController = gameController;
        this.miniMax = miniMax;
        initListeners();
    }

    private void startGame() {
        gameController.enableBoard();
    }

    private void initListeners() {

        // #TODO: Consider using card layout for start button
        // #TODO: Delegate creating action listeners to separate classes (or make them inner)
        // #TODO: Make difficulty slider non changeable after clicking start
        // #TODO: Add functionality to reset button

        menuPanel.getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == menuPanel.getNewGameButton()) {

                   menuPanel.setNewGameButtonColor(BUTTON_BACKGROUND_COLOR);
                   menuPanel.setNewGameButtonText("RESET");
                   menuPanel.setTurnInfoText("Your Turn");

                   startGame();

                   menuPanel.disableSlider();

                }
            }
        });

        menuPanel.getDifficultySlider().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                miniMax.setMaxDepth(menuPanel.getDifficultySlider().getValue());
                menuPanel.setTurnInfoText("Chosen Difficulty: " + menuPanel.getDifficultySlider().getValue());
            }
        });
    }

}
