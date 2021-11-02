class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int runningSum = 0;
        int cnt = 0;
        
        for (int num: nums) {
            runningSum = (runningSum + num) % k;
            if (runningSum < 0)
                runningSum = runningSum + k;
            if (map.containsKey(runningSum))
                cnt += map.get(runningSum);
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        
        return cnt;
    }
}