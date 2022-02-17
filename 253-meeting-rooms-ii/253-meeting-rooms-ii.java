class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int[] interval: intervals) {
            if (!pq.isEmpty()) {
                if (pq.peek() <= interval[0]) {
                    pq.poll();
                }
            }
            pq.add(interval[1]);
        }
        
        return pq.size();
    }
}