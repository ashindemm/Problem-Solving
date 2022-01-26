class Solution {
    public int maxSubArray(int[] nums) {
        int max_subarray = nums[0];
        int curr_subarray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr_subarray = Math.max(nums[i], curr_subarray + nums[i]);
            max_subarray = Math.max(max_subarray, curr_subarray);
        }
        return max_subarray;
    }
}