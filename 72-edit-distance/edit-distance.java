class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(); int m = word2.length();

        int[][] dp = new int[n][m];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,word1,word2,dp);
    }

    public int helper(int i,int j,String s1,String s2,int[][] dp){
        if(j == s2.length())return s1.length() - i;
        if(i == s1.length())return s2.length() - j;

        if(dp[i][j] != -1)return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(i+1,j+1,s1,s2,dp);
        }
        else{
            int replace = 1 + helper(i+1,j+1,s1,s2,dp);
            int delete = 1 + helper(i+1,j,s1,s2,dp);
            int insert = 1 + helper(i,j+1,s1,s2,dp);

            return dp[i][j] = Math.min(replace,Math.min(delete,insert));
        }
    }
}