class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timestamp = new TreeMap<Integer, Integer>();
        for (int[] trip: trips) {
            timestamp.put(trip[1], timestamp.getOrDefault(trip[1], 0) + trip[0]);
            timestamp.put(trip[2], timestamp.getOrDefault(trip[2], 0) - trip[0]);
        }
        
        int totalPassengers = 0;
        for (int passengers: timestamp.values()) {
            totalPassengers += passengers;
            if (totalPassengers > capacity)
                return false;
        }
        return true;
    }
}