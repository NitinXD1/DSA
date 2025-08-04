class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(); int m = text2.length();

        int[][] dp = new int[n][m];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,text1,text2,dp);
    }

    public int helper(int i,int j,String str1,String str2,int[][] dp){
        if(i >= str1.length() || j >= str2.length())return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int take = 0;
        if(str1.charAt(i) == str2.charAt(j))take = 1 + helper(i+1,j+1,str1,str2,dp);
        int left = helper(i+1,j,str1,str2,dp);
        int right = helper(i,j+1,str1,str2,dp);

        return dp[i][j] = Math.max(take,Math.max(left,right));
    }
}