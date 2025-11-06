class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,prices,dp);
    }

    public int helper(int index,int buy,int[] prices,int[][] dp){
        if(index == prices.length)return 0;

        if(dp[index][buy] != -1)return dp[index][buy];

        int skip = helper(index+1,buy,prices,dp);
        int take = 0;
        if(buy == 0){
            take = -prices[index] + helper(index+1,buy+1,prices,dp);
        }
        else  if(buy == 1){
            take = prices[index] + helper(index+1,buy-1,prices,dp);
        }

        return dp[index][buy] = Math.max(skip,take);
    }
}