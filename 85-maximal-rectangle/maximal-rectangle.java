class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] row = new int[matrix[0].length];

        int ans = 0;
        for(char[] r : matrix){
            for(int i=0;i<r.length;i++){
                char ch = r[i];
                if(ch == '1'){
                    row[i] += 1;
                }
                else{
                    row[i] = 0;
                }
            }
            ans = Math.max(ans,helper(row));
        }

        return ans;
    }

    public int helper(int[] row){
        int n = row.length;

        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && row[st.peek()] >= row[i]){
                int idx = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;

                int width = nse - pse - 1;
                ans = Math.max(ans,width*row[idx]);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int idx = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            int nse = n;
            int width = nse - pse - 1;
            ans = Math.max(ans,width*row[idx]);
        }

        return ans;
    }
}