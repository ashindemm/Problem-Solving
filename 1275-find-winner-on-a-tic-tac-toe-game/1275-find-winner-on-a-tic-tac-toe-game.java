class Solution {
    public String tictactoe(int[][] moves) {
        Character[][] board = new Character[3][3];
        
        boolean playerA = true;
        for (int[] move: moves) {
            board[move[0]][move[1]] = playerA ? 'X' : 'O';
            playerA = !playerA;
        }
        
        for (int r = 0; r < 3; r++)
            if (board[r][0] != null && board[r][0] == board[r][1] && board[r][1] == board[r][2])
                return board[r][0] == 'X' ? "A" : "B";
        
        for (int c = 0; c < 3; c++)
            if (board[0][c] != null && board[0][c] == board[1][c] && board[1][c] == board[2][c])
                return board[0][c] == 'X' ? "A" : "B";

        if (board[1][1] != null)
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))
                return board[1][1] == 'X' ? "A" : "B";
        
        if (moves.length >= 9)
            return "Draw";
        
        return "Pending";
    }
}