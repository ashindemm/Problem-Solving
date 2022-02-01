class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1)
            return -1;

        int[] degreeSum = new int[n+1];
        
        for (int[] t: trust) {
            degreeSum[t[1]]++;
            degreeSum[t[0]]--;
        }
        
        for (int i = 1; i <= n; i++) {
            if (degreeSum[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}