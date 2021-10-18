class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge: edges) {
            int c1 = unionFind(edge[0], parent);
            int c2 = unionFind(edge[1], parent);
            
            if (c1 != c2) {
                n--;
                parent[c2] = c1;
            }
        }
        return n;
    }
    
    public int unionFind(int c, int[] parent) {
        while(c != parent[c]) {
            parent[c] = parent[parent[c]];
            c = parent[c];
        }
        return c;
    }
}