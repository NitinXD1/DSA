class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(); int m = s2.length();
        if(s1.length() + s2.length() !=  s3.length())return false;

        if(s1.length() == 0)return s3.equals(s2);
        if(s2.length() == 0)return s3.equals(s1);

        int[][][] dp = new int[n][m][s3.length()];
        for(int[][] i:dp){
            for(int[] j:i)Arrays.fill(j,-1);
        }

        return helper(0,0,0,s1,s2,s3,dp);
    }

    public boolean helper(int i,int j,int k,String s1,String s2,String s3,int[][][] dp){

        if(i == s1.length()){
            return s2.substring(j,s2.length()).equals(s3.substring(k,s3.length()));
        }

        if(j == s2.length()){
            return s1.substring(i,s1.length()).equals(s3.substring(k,s3.length()));
        }

        if(dp[i][j][k] != -1)return dp[i][j][k] == 1 ? true : false;

        boolean ans = false;
        
        if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            ans = helper(i+1,j,k+1,s1,s2,s3,dp) || helper(i,j+1,k+1,s1,s2,s3,dp);
        }
        else if(s1.charAt(i) == s3.charAt(k)){
            ans = helper(i+1,j,k+1,s1,s2,s3,dp);
        }
        else if(s2.charAt(j) == s3.charAt(k)){
            ans = helper(i,j+1,k+1,s1,s2,s3,dp);
        }
        
        dp[i][j][k] = ans ? 1 : 0;

        return ans;
    }
}