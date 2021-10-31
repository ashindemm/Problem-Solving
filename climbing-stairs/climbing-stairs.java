class Solution {
    int[] memo = new int[46];
    public int climbStairs(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 1 || n == 2) {
            memo[n] = n;
            return n;
        }
        memo[n] = climbStairs(n-1) + climbStairs(n-2);
        return memo[n];
    }
}