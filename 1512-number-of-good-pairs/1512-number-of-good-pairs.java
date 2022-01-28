class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int num = 0;
        for (int f: freq.values()) {
            num += f * (f-1) / 2;
        }
        return num;
    }
}