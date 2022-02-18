class Solution {
    Map<Character, String> letterMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    List<String> combinations = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0)
            backtrack(0, digits, new StringBuilder());

        return combinations;
    }

    public void backtrack(int index, String digits, StringBuilder s) {
        if (s.length() == digits.length()) {
            combinations.add(s.toString());
            return;
        }
        
        String letters = letterMap.get(digits.charAt(index));
        for (char letter: letters.toCharArray()) {
            s.append(letter);
            backtrack(index + 1, digits, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}