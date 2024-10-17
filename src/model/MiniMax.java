package model;

public class MiniMax {

    Board board;
    private int maxDepth = 1;

    void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    int evaluate() {
        char gameState = board.checkGameState();

        if (gameState == 'o')
            return 10;
        else if (gameState == 'x')
            return -10;
        else
            return 0;
    }

    int minimax(int depth, int maxDepth, boolean isMaximizing, int alpha, int beta) {
        int score = evaluate();

        if(depth >= maxDepth)
            return score;

        if(score == 10)
            return score - depth;

        if(score == -10)
            return score + depth;

        if(board.isGameFinished())
            return 0;

        int best;

        if(isMaximizing){
            best = Integer.MIN_VALUE;

            for(int row =0; row< board.getSize(); row++){
                for(int col = 0; col < board.getSize(); col++){
                    if (board.makeMove(row, col, 'o')){
                        best = Math.max(best, minimax(depth + 1, this.maxDepth, !isMaximizing, alpha, beta));
                        alpha = Math.max(alpha, best);

                        board.board[row][col] = '0';

                        if (beta <= alpha)
                            break;
                    }
                }
            }
        }

        else{
            best = Integer.MAX_VALUE;

            for(int row = 0; row < board.getSize(); row++){
                for(int col = 0; col < board.getSize(); col++){
                    if (board.makeMove(row, col, 'x')){
                        best = Math.min(best, minimax(depth + 1, this.maxDepth, !isMaximizing, alpha, beta));
                        beta = Math.min(beta, best);

                        board.board[row][col] = '0';

                        if(beta <= alpha)
                            break;
                    }
                }
            }
        }
        return best;
    }

    Pair<Integer, Integer> findBestMove() {
        int bestValue = Integer.MIN_VALUE;
        int moveValue = 0;
        Pair<Integer, Integer> bestMove = new Pair<>(-1, -1);

        for(int row = 0; row < board.getSize(); row++){
            for(int col = 0; col < board.getSize(); col++){
                if (board.makeMove(row, col, 'o')){
                    moveValue = minimax(0, this.maxDepth, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board.board[row][col] = '0';

                    if (moveValue > bestValue){
                        bestMove.setFirst(row);
                        bestMove.setSecond(col);
                        bestValue = moveValue;
                    }
                }
            }
        }

        return bestMove;
    }

}
