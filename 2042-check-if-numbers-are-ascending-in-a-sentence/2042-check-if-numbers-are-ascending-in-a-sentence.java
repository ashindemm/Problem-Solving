class Solution {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int prevNum = -1;
        for (String token: tokens) {
            int num = sToI(token);
            if (num != -2) {
                if (num <= prevNum)
                    return false;
                prevNum = num;
            }
        }
        return true;
    }
    
    public int sToI(String token) {
        int num = -2;
        try {
            num = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return -2;
        }
        return num;
    }
}