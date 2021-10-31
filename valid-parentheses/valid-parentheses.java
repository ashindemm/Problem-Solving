class Solution {
    private static Map<Character, Character> brackets = new HashMap<Character, Character>();
    
    static {
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
    }
    public boolean isValid(String s) {
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> charStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))) {
                if (charStack.isEmpty() || charStack.pop() != brackets.get(s.charAt(i))) {
                    return false;
                }
            } else {
                charStack.push(s.charAt(i));
            }
        }
        return charStack.isEmpty();
    }
}