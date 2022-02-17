class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if (grid[r][c] == '1') {
                    islands += 1;
                    dfs(r, c, grid);
                }
            }
        }
        return islands;
    }
    
    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length 
            || col < 0 || col >= grid[0].length)
            return;

        if (grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(row, col - 1, grid);
            dfs(row, col + 1, grid);
            dfs(row - 1, col, grid);
            dfs(row + 1, col, grid);
        }
    }
}