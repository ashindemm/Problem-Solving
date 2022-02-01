class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 1)
            return true;
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num: arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        List<Integer> vals = new ArrayList(freq.values());
        Collections.sort(vals);
        for (int i = 1; i < vals.size(); i++) {
            if (vals.get(i) == vals.get(i-1))
                return false;
        }
        return true;
    }
}