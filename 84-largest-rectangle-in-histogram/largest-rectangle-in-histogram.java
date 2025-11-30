class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int max = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int val = heights[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                max = Math.max(max,(right-left-1) * val);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int val = heights[st.pop()];
            int right = n;
            int left = st.isEmpty() ? -1 : st.peek();

            max = Math.max(max,(right-left-1) * val);
        }

        return max;
    }
}