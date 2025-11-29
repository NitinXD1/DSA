class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        List<String> ans = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(index == target.length)break;
            st.push(i);
            ans.add("Push");

            if(!st.isEmpty()){
                if(target[index] != st.peek()){
                    st.pop();
                    ans.add("Pop");
                }
            }
            if(i == target[index])index++;
            
        }

        return ans;
    }
}