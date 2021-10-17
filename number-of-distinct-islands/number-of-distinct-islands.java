class Solution {
    public int numDistinctIslands(int[][] grid) {
        int count = 0;
        Set<String> dir = new HashSet<String>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    String directions = sb.toString();
                    System.out.println(directions);
                    if (!dir.contains(directions)) {
                        count ++;
                        dir.add(directions);
                    }
                    
                }
            }
        }
        System.out.println(dir);
        return count;
    }
    
    public void dfs(int[][] grid, int row, int col, StringBuilder sb) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return;

        if (grid[row][col] == 1) {
            grid[row][col] = 0;
            dfs(grid, row + 1, col, sb);
            sb.append("D");
            dfs(grid, row - 1, col, sb);
            sb.append("U");
            dfs(grid, row, col + 1, sb);
            sb.append("R");
            dfs(grid, row, col - 1, sb);
            sb.append("L");
        }
        
    }
}