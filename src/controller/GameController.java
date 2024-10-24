package controller;

import view.*;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private final BoardPanel boardPanel;
    private final MenuPanel menuPanel;
    private final Board board;
    private final MiniMax miniMax;

    public GameController(BoardPanel boardPanel, MenuPanel menuPanel, Board board, MiniMax miniMax) {
        this.boardPanel = boardPanel;
        this.menuPanel = menuPanel;
        this.board = board;
        this.miniMax = miniMax;

        initListeners();
    }

    public void enableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardPanel.getBoardButton(row, col).setEnabled(true);
            }
        }
    }

    public void makeBotMove(){

        if (board.getCurrentPlayer() == 'o' && board.getGameState() == 'u'){
            Pair <Integer, Integer> bestMove;
            bestMove = miniMax.findBestMove(board);

            if (board.makeMove(bestMove.getFirst(), bestMove.getSecond(), board.getCurrentPlayer())){

                boardPanel.updateSquare(bestMove.getFirst(), bestMove.getSecond(), 'o');

                board.setGameState(board.checkGameState());
                board.setCurrentPlayer('x');
            }
        }
    }

    // #TODO: needs to be refactored - too many indentation levels
    private void initListeners() {

        // This is the "Main Game Loop"
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                int finalRow = row;
                int finalCol = col;

                boardPanel.getBoardButton(row, col).addActionListener(e -> {

                    if (e.getSource() == boardPanel.getBoardButton(finalRow, finalCol) && board.getGameState() == 'u'){

                        if(board.makeMove(finalRow, finalCol, board.getCurrentPlayer())){

                            boardPanel.updateSquare(finalRow, finalCol, board.getCurrentPlayer());
                            board.setGameState(board.checkGameState());
                            board.changePlayer();
                            menuPanel.setTurnInfoText("Bot's Turn");

                            makeBotMove();

                            menuPanel.setTurnInfoText("Your Turn");
                        }

                        if(board.getGameState() == 'x') {
                            menuPanel.setTurnInfoText("You Win!");
                            boardPanel.highlightWinningSquare();
                        }
                        else if(board.getGameState() == 'o') {
                            menuPanel.setTurnInfoText("Bot Win's!");
                            boardPanel.highlightWinningSquare();
                        }
                    }
                });

            }
        }
    }
}

