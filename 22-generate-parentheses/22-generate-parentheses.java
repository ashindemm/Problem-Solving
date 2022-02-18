class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    public void backtrack(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }
        
        if (open < n) {
            sb.append("(");
            backtrack(res, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(")");
            backtrack(res, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}