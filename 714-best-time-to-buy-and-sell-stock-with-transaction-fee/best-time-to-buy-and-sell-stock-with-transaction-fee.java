class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,1,prices,fee,dp);
    }

    public int helper(int index,int buy,int[] prices,int fee,int[][] dp){
        if(index == prices.length)return 0;

        if(dp[index][buy] != -1)return dp[index][buy];
        
        int skip = helper(index+1,buy,prices,fee,dp);
        int profit = 0;

        if(buy == 1){
            int invest = -prices[index] + helper(index+1,0,prices,fee,dp);
            profit = Math.max(skip,invest);
        }
        else{
            int sell = prices[index] - fee + helper(index+1,1,prices,fee,dp);
            profit = Math.max(sell,skip);
        }

        return dp[index][buy] = profit;
    }
}