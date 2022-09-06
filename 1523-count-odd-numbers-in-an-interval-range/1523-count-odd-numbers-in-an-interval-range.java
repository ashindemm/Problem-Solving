class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if (low % 2 == 1) {
            count ++;
            low += 1;
        }
        
        if (high % 2 == 1) {
            count ++;
            high -= 1;
        }
        
        count += ((high - low) / 2);
        
        return count;
    }
}