package model;

public class MiniMax {

    private int maxDepth = 0;

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    int evaluate(Board board) {
        char gameState = board.checkGameState();

        if (gameState == 'o')
            return 10;
        else if (gameState == 'x')
            return -10;
        else
            return 0;
    }

    int minimax(Board board, int depth, int maxDepth, boolean isMaximizing, int alpha, int beta) {
        int score = evaluate(board);

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
                        best = Math.max(best, minimax(board,depth + 1, this.maxDepth, !isMaximizing, alpha, beta));
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
                        best = Math.min(best, minimax(board,depth + 1, this.maxDepth, !isMaximizing, alpha, beta));
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

    public Pair<Integer, Integer> findBestMove(Board board) {
        int bestValue = Integer.MIN_VALUE;
        int moveValue = 0;
        Pair<Integer, Integer> bestMove = new Pair<>(-1, -1);

        for(int row = 0; row < board.getSize(); row++){
            for(int col = 0; col < board.getSize(); col++){

                // #TODO: Move this if statement to a helper function to improve readability
                if (board.makeMove(row, col, 'o')){

                    moveValue = minimax(board,0, this.maxDepth, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
