class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,3,prices,dp);
    }

    public int helper(int index,int buy,int[] prices,int[][] dp){
        if(buy == -1 || index == prices.length)return 0;

        if(dp[index][buy] != -1)return dp[index][buy];

        int skip = helper(index+1,buy,prices,dp);
        int profit = 0;

        if(buy%2==1){
            int invest = -prices[index] + helper(index+1,buy-1,prices,dp);
            profit = Math.max(skip,invest);
        }
        else{
            int sell = prices[index] + helper(index+1,buy-1,prices,dp);
            profit = Math.max(sell,skip);
        }

        return dp[index][buy] = profit;
    }
}