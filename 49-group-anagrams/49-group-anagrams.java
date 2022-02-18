class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
        List<List<String>> anagrams = new ArrayList<List<String>>();
        for (String str: strs) {
            String key = getHash(str);
            List<String> lst = anagramMap.getOrDefault(key, new ArrayList<String>());
            lst.add(str);
            anagramMap.put(key, lst);
        }
        
        for (List<String> val: anagramMap.values()) {
            anagrams.add(val);
        }
        return anagrams;
    }
    
    public String getHash(String str) {
        int[] chars = new int[26];
        for (Character c: str.toCharArray()) {
            chars[c - 'a']++;
        }
        return Arrays.toString(chars);
    }
}