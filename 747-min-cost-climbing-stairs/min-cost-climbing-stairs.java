class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        return Math.min(helper(0,cost,dp),helper(1,cost,dp));
    }

    public int helper(int index,int[] cost,int[] dp){
        if(index >= cost.length)return 0;

        if(dp[index] != -1)return dp[index];

        int oneStep = helper(index+1,cost,dp);
        int twoStep = helper(index+2,cost,dp);

        return dp[index] = Math.min(oneStep,twoStep) + cost[index];
    }
}