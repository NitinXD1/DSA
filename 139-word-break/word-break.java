class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {    
        HashSet<String> st = new HashSet<>();

        for(String str : wordDict){
            st.add(str);
        }

        int n = s.length();

        int[][] dp = new int[n+1][n+1];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,st,s,dp);
    }

    public boolean helper(int start,int end,HashSet<String> st,String s,int[][] dp){
        if(start == s.length()){
            return end == s.length();
        }

        if(dp[start][end] != -1)return dp[start][end] == 1;
        
        boolean leave = helper(start+1,end,st,s,dp);
        boolean take = false;
        if(st.contains(s.substring(end,start+1))){
            take = helper(start+1,start+1,st,s,dp);
        }

        dp[start][end] = leave || take ? 1 : 0;
        return leave || take;
    }
}