class Solution {
    public int numDecodings(String s) {
        HashSet<String> st = new HashSet<>();
        
        for(int i=1;i<=26;i++){
            st.add(String.valueOf(i));
        }

        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,st,s,dp);
    }

    public int helper(int start,int end,HashSet<String> st,String s,int[][] dp){
        if(start == s.length()){
            return end == s.length() ? 1 : 0;
        }

        if(dp[start][end] != -1)return dp[start][end];

        int leave = helper(start+1,end,st,s,dp);
        int take = 0;
        if(st.contains(s.substring(end,start+1))){
            take = helper(start+1,start+1,st,s,dp);
        }

        return dp[start][end] = leave + take;
    }
}