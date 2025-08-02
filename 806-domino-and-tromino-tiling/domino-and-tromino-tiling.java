class Solution {
    int mod = (int)(1e9 + 7);
    public int numTilings(int n) {
        int[] dp = new int[n+1];

        if(n <= 1)return 1;
        if(n == 2)return 2;
        if(n == 3)return 5;

        dp[1]=1;dp[0]=1;dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i] = (int) ((2L * dp[i-1] + dp[i-3]) % mod);
        }

        return dp[n];
    }
}