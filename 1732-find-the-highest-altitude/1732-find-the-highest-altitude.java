class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int sum = 0;
        for (int i: gain) {
            sum += i;
            maxHeight = Math.max(maxHeight, sum);
        }
        return maxHeight;
    }
}