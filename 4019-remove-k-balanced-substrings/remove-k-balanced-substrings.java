class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            stack.push(ch);

            if (stack.size() >= 2 * k) {
                boolean isKBalanced = true;

                for (int i = 0; i < k; i++) {
                    if (stack.get(stack.size() - 1 - i) != ')') {
                        isKBalanced = false;
                        break;
                    }
                }

                if (isKBalanced) {
                    for (int i = k; i < 2 * k; i++) {
                        if (stack.get(stack.size() - 1 - i) != '(') {
                            isKBalanced = false;
                            break;
                        }
                    }
                }

                if (isKBalanced) {
                    for (int i = 0; i < 2 * k; i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString(); 
    }
}