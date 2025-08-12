class Solution {
    int mod = 1000000007;

    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++)dp[i][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
                int leave = dp[i-1][j];
                int take = 0;
                if(j - Math.pow(i,x) >= 0){
                    take = dp[i-1][j - (int)Math.pow(i,x)];
                }

                dp[i][j] = (leave + take) % mod;
            }
        }

        return dp[n][n];
    }
}