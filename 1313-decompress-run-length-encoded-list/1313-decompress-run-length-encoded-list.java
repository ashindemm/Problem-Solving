class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                lst.add(nums[i+1]);
            }
        }
        int[] result = new int[lst.size()];
        for (int i = 0; i< lst.size(); i++) {
            result[i] = lst.get(i);
        }
        return result;
    }
}