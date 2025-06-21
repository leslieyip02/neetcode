class Solution {
    private List<String> generated;

    private void generate(LinkedList<Character> stack, int open, int close, int n) {
        if (stack.size() == n * 2) {
            StringBuilder sb = new StringBuilder();
            for (char bracket : stack) {
                sb.append(bracket);
            }
            generated.add(sb.toString());
            return;
        }

        if (open > 0) {
            stack.addLast('(');
            generate(stack, open - 1, close, n);
            stack.removeLast();
        }
        if (close > open) {
            stack.addLast(')');
            generate(stack, open, close - 1, n);
            stack.removeLast();
        }
    }

    public List<String> generateParenthesis(int n) {
        generated = new ArrayList<>();
        generate(new LinkedList<>(), n, n, n);
        return generated;
    }
}

