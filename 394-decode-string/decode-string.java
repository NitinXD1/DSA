class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> numSt = new Stack<>();

        int num = 0;
        StringBuilder curr = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else{
                if(ch == '['){
                    numSt.push(num);
                    str.push(curr);
                    curr = new StringBuilder();
                    num = 0;
                }
                else if(ch == ']'){
                    StringBuilder prev = str.pop();
                    int cnt = numSt.pop();
                    for(int i=0;i<cnt;i++){
                        prev.append(curr);
                    }

                    curr = prev;
                }
                else{
                    curr.append(ch);
                }
            }
        }

        return curr.toString();
    }
}