class Solution {
    public static int modulo = (int) Math.pow(10, 9) + 7;
    public int knightDialer(int n) {
        long ans = 0;
        Map<String, Long> memo = new HashMap<String, Long>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dfs(n, i, j, memo)) % modulo;
            }
        }
        return (int) ans;
    }
    
    public static long dfs(int n, int i, int j, Map<String, Long> memo) {
        if (i < 0 || j < 0 || i > 3 || j > 2 || (i == 3 && j != 1))
            return 0;
        if (n == 1)
            return 1;
        
        String key = "" + n + "_" + i + "_" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        long ans = (dfs(n-1, i-1, j-2, memo) % modulo + dfs(n-1, i-1, j+2, memo) % modulo
            + dfs(n-1, i+1, j-2, memo) % modulo + dfs(n-1, i+1, j+2, memo) % modulo
            + dfs(n-1, i-2, j-1, memo) % modulo + dfs(n-1, i-2, j+1, memo) % modulo
            + dfs(n-1, i+2, j-1, memo) % modulo + dfs(n-1, i+2, j+1, memo) % modulo);
        
        memo.put(key, ans);
        return memo.get(key);
    }
}