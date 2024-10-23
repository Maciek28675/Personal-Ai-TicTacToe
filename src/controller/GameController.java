package controller;

import view.BoardPanel;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private final BoardPanel boardPanel;
    private final Board board;
    private final MiniMax miniMax;

    public GameController(BoardPanel boardPanel, Board board, MiniMax miniMax) {
        this.boardPanel = boardPanel;
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

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                int finalRow = row;
                int finalCol = col;

                boardPanel.getBoardButton(row, col).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == boardPanel.getBoardButton(finalRow, finalCol) && board.getGameState() == 'u'){

                            if(board.makeMove(finalRow, finalCol, board.getCurrentPlayer())){

                                boardPanel.updateSquare(finalRow, finalCol, board.getCurrentPlayer());
                                board.setGameState(board.checkGameState());
                                board.changePlayer();

                                makeBotMove();
                            }

                            if(board.getGameState() != 'u')
                                boardPanel.highlightWinningSquare();

                        }
                    }
                });

            }
        }
    }
}

