package controller;

import view.MenuPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

    private final MenuPanel menuPanel;
    private final GameController gameController;

    private final static Color BUTTON_BACKGROUND_COLOR = new Color(238, 79, 79);

    public MenuController(MenuPanel menuPanel, GameController gameController) {
        this.menuPanel = menuPanel;
        this.gameController = gameController;
        initListeners();
    }

    private void startGame() {
        gameController.enableBoard();
    }

    private void initListeners() {

        // #TODO: Consider using card layout for start button
        
        menuPanel.getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == menuPanel.getNewGameButton()) {

                   menuPanel.setNewGameButtonColor(BUTTON_BACKGROUND_COLOR);
                   menuPanel.setNewGameButtonText("RESET");
                   menuPanel.setTurnInfoText("Your Turn!");

                   startGame();

                }
            }
        });
    }

}
