class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        
        int currRow = 0;
        boolean down = false;
        
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1)
                down = !down;
            
            currRow += (down ? 1 : -1);
        }
        
        String result = "";
        for (StringBuilder sb: rows) {
            result += sb.toString();
        }
        
        return result;
    }
}