class Solution {
    public int findComplement(int num) {
        int complement = num;
        complement |= complement >> 1;
        complement |= complement >> 2;
        complement |= complement >> 4;
        complement |= complement >> 8;
        complement |= complement >> 16;
        complement |= complement >> 32;
        
        return complement ^ num;
    }
}