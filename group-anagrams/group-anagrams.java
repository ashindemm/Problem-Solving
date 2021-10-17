class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        for (String s: strs) {
            String key = getKey(s);
            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(s);
            } else {
                anagramMap.put(key, new ArrayList() {{
                    add(s);
                }});
            }
        }
        return new ArrayList(anagramMap.values());
    }
    
    public String getKey(String s) {
        int[] count = new int[26];
        
        for (Character c: s.toCharArray()) {
            count[c - 'a']++;
        }
        
        String key = "";
        for (int i : count) {
            key += '#' + i;
        }
        return key;
    }
}