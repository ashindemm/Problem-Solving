class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> freq2 = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums1.length; i++) {
            freq1.put(nums1[i], freq1.getOrDefault(nums1[i], 0) + 1);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            freq2.put(nums2[i], freq2.getOrDefault(nums2[i], 0) + 1);
        }
        List<Integer> intersection = new ArrayList<Integer>();
        if (nums1.length >= nums2.length) {
            for (int num : nums2) {
                if (freq1.containsKey(num) && freq1.get(num) > 0) {
                    intersection.add(num);
                    freq1.put(num, freq1.get(num) - 1);
                }
            }
        } else {
            for (int num : nums1) {
                if (freq2.containsKey(num) && freq2.get(num) > 0) {
                    intersection.add(num);
                    freq2.put(num, freq2.get(num) - 1);
                }
            }
        }
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
}