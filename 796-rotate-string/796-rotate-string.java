class Solution {
    public boolean rotateString(String s, String goal) {
        String rotated = s.substring(1, s.length()) + s.charAt(0);
        while (!rotated.equals(s)) {
            if (rotated.equals(goal))
                return true;
            rotated = rotated.substring(1, s.length()) + rotated.charAt(0);
        }
        return false;
    }
}