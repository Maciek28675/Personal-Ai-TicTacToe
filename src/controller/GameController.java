package controller;

import view.BoardPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private final BoardPanel boardPanel;

    public GameController(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    public void enableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardPanel.getBoardButton(row, col).setEnabled(true);
            }
        }
    }

    // #TODO: Add action listeners for board buttons - updated board state after clicking a button and change players
    // #TODO: Change color of winning squares after win
    // #TODO: After player's move, make Ai move
}

