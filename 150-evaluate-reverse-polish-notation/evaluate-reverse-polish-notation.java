class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        if(tokens.length == 1)return Integer.parseInt(tokens[0]);

        for(String str:tokens){
            if(str.equals("+") || str.equals("*") || str.equals("/") || str.equals("-")){
                int second = st.pop();
                int first = st.pop();

                if(str.equals("*")){
                    ans = (first * second);
                    st.push(first * second);
                }
                else if(str.equals("+")){
                    ans = (first + second);
                    st.push(first + second);
                }
                else if(str.equals("/")){
                    ans = (first / second);
                    st.push(first / second);
                }
                else{
                    ans = (first - second);
                    st.push(first - second);
                }
            }
            else st.push(Integer.parseInt(str));
        }

        return ans;
    }
}