class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> complements = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case '(':
                case '[':
                case '{':
                    stack.push(current);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || stack.peek() != complements.get(current)) {
                        return false;
                    }
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();
    }
}

