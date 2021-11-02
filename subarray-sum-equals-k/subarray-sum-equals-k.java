class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        sums.put(0, 1);
        
        int runningSum = 0;
        int cnt = 0;
        for (int num: nums) {
            runningSum += num;
            if (sums.containsKey(runningSum - k)) {
                cnt += sums.get(runningSum - k);
            }
            sums.put(runningSum, sums.getOrDefault(runningSum, 0) + 1);
        }
        return cnt;
    }
}