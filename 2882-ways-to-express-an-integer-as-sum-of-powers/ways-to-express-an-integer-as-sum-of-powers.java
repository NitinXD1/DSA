class Solution {
    int mod = 1000000007;
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];

        for(int[] i: dp)Arrays.fill(i,-1);

        return helper(1,n,x,dp);
    }

    public int helper(int ind,int n,int x,int[][] dp){
        if(ind > n)return 0;
        if(n == 0 || Math.pow(ind,x) == n)return 1;

        if(dp[ind][n] != -1)return dp[ind][n];

        int leave = helper(ind+1,n,x,dp);
        int take = 0;
        if(n - (int)Math.pow(ind,x) >= 0)take = helper(ind+1,n-(int)Math.pow(ind,x),x,dp);

        return dp[ind][n] = (leave + take) % mod;
    }
}