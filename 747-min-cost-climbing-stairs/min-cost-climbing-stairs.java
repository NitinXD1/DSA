class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];

        for(int i=n-1;i>=0;i--){
            int oneStep = dp[i+1];
            int twoStep = dp[i+2];

            dp[i] = cost[i] + Math.min(oneStep,twoStep);
        }

        return Math.min(dp[0],dp[1]);
    }
}