class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder prev = strStack.pop();
                int count = numStack.pop();
                for (int i = 0; i < count; i++) {
                    prev.append(curr);
                }
                curr = prev;
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
