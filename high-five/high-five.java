class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        Arrays.sort(items, (a,b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            }
            return 0;
        });
        Map<Integer, Integer> idScoreCnt = new HashMap<Integer, Integer>();
        for (int[] item : items) {
            if (idScoreCnt.containsKey(item[0])) {
                idScoreCnt.put(item[0], idScoreCnt.get(item[0]) + 1);
            } else {
                idScoreCnt.put(item[0], 1);
            }
        }
        
        Map<Integer, Boolean> idVisited = new HashMap<Integer, Boolean>();
        int[][] results = new int[idScoreCnt.size()][2];
        int lower = 0;
        int upper = 0;
        int count = -1;
        for (int i = 0; i < items.length; i++) {
            int currentId = items[i][0];
            int currentScore = items[i][1];
            if (!idVisited.containsKey(currentId)) {
                count++;
                idVisited.put(currentId, true);
                results[count] = new int[]{currentId, 0};
                upper += idScoreCnt.get(currentId);
                lower = upper - 5;
            }

            if (idVisited.get(currentId) && 
                i >= lower && i < upper) {
                results[count][1] += currentScore;
            }
        }
        
        for(int[] result: results) {
            result[1] = result[1]/5;
        }
        return results;
    }
}