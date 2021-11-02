class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<String, List<String>>();
        for (String s: strs) {
            String key = getHash(s);
            List<String> lst = hash.getOrDefault(key, new ArrayList<String>());
            lst.add(s);
            hash.put(key, lst);
        }
        
        List<List<String>> result = new ArrayList();
        for (Map.Entry<String, List<String>> entry: hash.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
    
    public String getHash(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        return Arrays.toString(chars);
    }
}