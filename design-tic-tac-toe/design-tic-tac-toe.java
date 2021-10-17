class TicTacToe {

    int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        
        boolean vert = true;
        boolean hori = true;
        boolean diag = row == col;
        boolean antidiag = row+col == board.length - 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (diag) {
                    if (row == col && i == j && board[i][j] != board[row][col]) {
                        diag = false;
                    }
                }

                if (antidiag) {
                    if (row + col == board.length - 1) {
                        if (i + j == board.length - 1 && board[i][j] != board[row][col]) {
                            antidiag = false;
                        }
                    }
                }
                
                if (vert) {
                    if (board[j][col] != board[row][col])
                        vert = false;
                }
                
                if (hori) {
                    if (board[row][j] != board[row][col])
                        hori = false;
                }
            }
        }
        return (vert || hori || diag || antidiag) ? player : 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */