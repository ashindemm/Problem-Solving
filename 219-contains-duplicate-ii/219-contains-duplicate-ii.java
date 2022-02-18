class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numset = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (numset.contains(nums[i]))
                return true;
            
            numset.add(nums[i]);
            if (numset.size() > k)
                numset.remove(nums[i - k]);
        }
        
        return false;
    }
}