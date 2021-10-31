class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> lst = new ArrayList(freq.entrySet());
        Collections.sort(lst, (Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> {
            if (a.getValue() == b.getValue())
                return b.getKey() - a.getKey();
            return a.getValue() - b.getValue();
        });
        
        int[] ans = new int[nums.length];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: lst) {
            for (int j = 0; j < entry.getValue(); j++)
                ans[i++] = entry.getKey();
        }
        
        return ans;
    }
}