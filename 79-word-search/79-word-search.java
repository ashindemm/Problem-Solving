class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean backtrack(int row, int col, char[][] board, String word, int posi) {
        if (word.length() <= posi)
            return true;
        
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(posi))
            return false;
        
        board[row][col] = '#';
        boolean exists = false;
        if (!exists)
            exists = backtrack(row + 1, col, board, word, posi + 1);
        if (!exists)
            exists = backtrack(row, col + 1, board, word, posi + 1);
        if (!exists)
            exists = backtrack(row - 1, col, board, word, posi + 1);
        if (!exists)
            exists = backtrack(row, col - 1, board, word, posi + 1);
        
        board[row][col] = word.charAt(posi);
        return exists;
    }
}