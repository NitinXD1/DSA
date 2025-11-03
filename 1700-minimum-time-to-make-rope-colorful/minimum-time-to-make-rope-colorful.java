class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> st = new Stack<>();
        int time = 0;
        st.push(0);
        int n = colors.length();

        for(int i=1;i<n;i++){
            int prev = st.isEmpty() ? -1 : st.peek();
            if(prev == -1 || colors.charAt(prev) != colors.charAt(i)){
                st.push(i);
            }
            else if(colors.charAt(prev) == colors.charAt(i) && neededTime[i] > neededTime[prev]){
                st.pop();
                time += neededTime[prev];
                st.push(i);
            }
            else time += neededTime[i];
        }

        return time;
    }
}