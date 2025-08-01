class Solution {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder();

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}