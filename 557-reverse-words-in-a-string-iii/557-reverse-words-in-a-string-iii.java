class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String reversed = "";
        for (String word: words) {
            reversed = reversed += reverse(word) + " ";
        }
        return reversed.substring(0, reversed.length() - 1);
    }
    
    public String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        for (int i = 0; i <= word.length() / 2; i++) {
            sb.setCharAt(i, word.charAt(word.length() - i - 1));
            sb.setCharAt(word.length() - i - 1, word.charAt(i));
        }
        return sb.toString();
    }
}