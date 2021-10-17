class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for (int[] log : logs) {
            int pa = findParent(parents, log[1]);
            int pb = findParent(parents, log[2]);
            
            if (pa != pb) {
                parents[pb] = pa;
                n--;
            }
            
            if (n == 1)
                return log[0];
        }
        
        return -1;
    }
    
    public int findParent(int[] parents, int child) {
        while (child != parents[child]) {
            child = parents[parents[child]];
        }
        
        return parents[child];
    }
}