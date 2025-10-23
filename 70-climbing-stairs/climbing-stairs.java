class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[n] = 1;
        for(int i=n-1;i>=0;i--){
            int oneStep = dp[i+1];
            int twoStep = i + 2 <= n ? dp[i+2] : 0;

            dp[i] = oneStep + twoStep;
        }

        return dp[0];
    }
}