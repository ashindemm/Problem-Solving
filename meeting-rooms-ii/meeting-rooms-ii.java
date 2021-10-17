class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int rooms = 0;
        for (int[] interval: intervals) {
            if (pq.size() == 0) {
                rooms ++;
            } else {
                if (interval[0] >= pq.peek()) {
                    pq.poll();
                } else {
                    rooms ++;
                }
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}