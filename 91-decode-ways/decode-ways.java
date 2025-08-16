class Solution {
    public int numDecodings(String s) {
        HashSet<String> st = new HashSet<>();
        
        for(int i=1;i<=26;i++){
            st.add(String.valueOf(i));
        }

        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i=n-1;i>=0;i--){
            int[] temp = new int[n+1];
            for(int j=n-1;j>=0;j--){
                int leave = dp[j];
                int take = 0;
                if(i >= j && st.contains(s.substring(j,i+1))){
                    take = dp[i+1];
                }

                temp[j] = leave + take;
            }
            dp = temp;
        }

        return dp[0];
    }
}