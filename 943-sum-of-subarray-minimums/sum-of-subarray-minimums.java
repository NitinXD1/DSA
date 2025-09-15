class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod =(int) 1e9+7;

        int[] nse = new int[n];
        int[] pse = new int[n];

        getNse(nse,arr);
        getPse(pse,arr);

        long total = 0;

        for(int i=0;i<n;i++){
            int prev = pse[i];
            int next = nse[i];
            int left = i - prev;
            int right = next - i;

            total = (total + (long)left * right * arr[i]) % mod;
        }

        return (int) total;
    }

    public void getNse(int[] nse,int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);  
        }
    }

    public void getPse(int[] pse,int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);  
        }
    }
}