class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,m,n,dp);
    }

    public int helper(int r,int c,int n,int m,int[][] dp){
        if(r == n-1 && c == m-1)return 1;

        if(r == n || c == m)return 0;

        if(dp[r][c] != -1)return dp[r][c];

        int down = helper(r+1,c,n,m,dp);
        int right = helper(r,c+1,n,m,dp);

        return dp[r][c] = down + right;
    }
}