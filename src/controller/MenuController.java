package controller;

import view.MenuPanel;
import model.*;

import java.awt.*;
import java.util.Objects;

public class MenuController {

    private final MenuPanel menuPanel;
    private final GameController gameController;
    private final MiniMax miniMax;

    private final static Color RESET_BUTTON_BACKGROUND_COLOR = new Color(231, 76, 60);
    private final static Color RESET_BUTTON_BORDER_COLOR = new Color(192, 57, 43);
    private final static Color START_BUTTON_BACKGROUND_COLOR = new Color(46, 204, 113);
    private final static Color START_BUTTON_BORDER_COLOR = new Color(39, 174, 96);

    public MenuController(MenuPanel menuPanel, GameController gameController, MiniMax miniMax) {
        this.menuPanel = menuPanel;
        this.gameController = gameController;
        this.miniMax = miniMax;
        initListeners();
    }

    private void initListeners() {

        // #TODO: Delegate creating action listeners to separate classes (or make them inner)
        menuPanel.getNewGameButton().addActionListener(e -> {

            if (e.getSource() == menuPanel.getNewGameButton()) {

               if (Objects.equals(menuPanel.getNewGameButton().getText(), "START")) {
                   menuPanel.setNewGameButtonColor(RESET_BUTTON_BACKGROUND_COLOR);
                   menuPanel.setNewGameButtonBorderColor(RESET_BUTTON_BORDER_COLOR);
                   menuPanel.setNewGameButtonText("RESET");
                   menuPanel.setTurnInfoText("Your Turn");

                   // Enable player to make a move
                   gameController.enableBoard();

                   menuPanel.disableSlider();
               }

               else if (Objects.equals(menuPanel.getNewGameButton().getText(), "RESET")) {
                   menuPanel.setNewGameButtonColor(START_BUTTON_BACKGROUND_COLOR);
                   menuPanel.setNewGameButtonBorderColor(START_BUTTON_BORDER_COLOR);
                   menuPanel.setNewGameButtonText("START");
                   menuPanel.setTurnInfoText("Chosen difficulty: " + menuPanel.getDifficultySlider().getValue());

                   gameController.resetGame();
                   gameController.disableBoard();

                   menuPanel.enableSlider();
               }

            }
        });

        menuPanel.getDifficultySlider().addChangeListener(_ -> {
            miniMax.setMaxDepth(menuPanel.getDifficultySlider().getValue());
            menuPanel.setTurnInfoText("Chosen Difficulty: " + menuPanel.getDifficultySlider().getValue());
        });
    }

}
