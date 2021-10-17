class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] charGraph = new int[26];
        for (int i = 0; i < 26; i++) {
            charGraph[i] = i;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            int a = unionFind(charGraph, s1.charAt(i) - 'a');
            int b = unionFind(charGraph, s2.charAt(i) - 'a');

            if (a < b) {
                charGraph[b] = a;
            } else {
                charGraph[a] = b;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append(Character.toString(unionFind(charGraph, baseStr.charAt(i) - 'a') + 'a'));
        }
        
        return sb.toString();
    }

    public int unionFind(int[] graph, int c) {
        while (c != graph[c]) {
            c = graph[c];
        }
        return graph[c];
    }
}