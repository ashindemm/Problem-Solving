class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] minCosts = new int[cost.length + 1];
        minCosts[0] = minCosts[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            minCosts[i] =  Math.min((minCosts[i-1] + cost[i-1]), (minCosts[i-2] + cost[i-2]));
        }
        return minCosts[cost.length];
    }
    
}