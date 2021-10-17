class WordDistance {
    Map<String, List<Integer>> wordIndexes = new HashMap<String, List<Integer>>();
    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!wordIndexes.containsKey(word)) {
                wordIndexes.put(word, new ArrayList<Integer>());
            }
            List<Integer> temp = wordIndexes.get(word);
            temp.add(i);
            wordIndexes.put(word, temp);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1 = wordIndexes.get(word1);
        List<Integer> w2 = wordIndexes.get(word2);
        
        int minDist = Integer.MAX_VALUE;
        
        for (int i : w1) {
            for (int j : w2) {
                minDist = Math.min(Math.abs(i-j), minDist);
            }
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */