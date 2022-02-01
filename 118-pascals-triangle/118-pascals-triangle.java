class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<Integer>();
            List<Integer> prevRow = triangle.get(i - 1);
            currRow.add(1);
            
            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            currRow.add(1);
            triangle.add(currRow);
        }
        
        return triangle;
    }
}