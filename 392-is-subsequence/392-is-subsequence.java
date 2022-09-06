class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        if (s.isEmpty())
            return true;

        for (char c: t.toCharArray()) {
            if (c == s.charAt(i)) {
                i++;
                if (i == s.length())
                    return true;
            }
        }
        
        return false;
    }
}