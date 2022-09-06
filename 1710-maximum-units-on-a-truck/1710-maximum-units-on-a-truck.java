class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int boxes = 0;
        for (int[] type: boxTypes) {
            int boxCount = Math.min(truckSize, type[0]);
            boxes += boxCount * type[1];
            
            truckSize -= boxCount;
            
            if (truckSize == 0)
                break;
        }
        
        return boxes;
    }
}