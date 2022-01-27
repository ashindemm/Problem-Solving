class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> ((int[] slot1, int[] slot2) -> slot1[0] - slot2[0] );
        
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration)
                pq.add(slot);
        }
        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration)
                pq.add(slot);
        }
        
        List<Integer> minAv = new ArrayList<Integer>();
        while (pq.size() > 1) {
            int[] a = pq.poll();
            int[] b = pq.peek();
            
            if (a[1] >= b[0] + duration) {
                minAv.add(b[0]);
                minAv.add(b[0] + duration);
                return minAv;
            }
        }
        return minAv;
    }
}