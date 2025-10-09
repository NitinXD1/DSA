class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];

        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }

        return helper(0,1,1,prices,dp);
    }

    public int helper(int index,int count,int buy,int[] prices,int[][][] dp){
        if(count == -1 || index == prices.length)return 0;

        if(dp[index][count][buy] != -1)return dp[index][count][buy];

        int skip = helper(index+1,count,buy,prices,dp);
        int profit = 0;

        if(buy==1){
            int invest = -prices[index] + helper(index+1,count,0,prices,dp);
            profit = Math.max(skip,invest);
        }
        else{
            int sell = prices[index] + helper(index+1,count-1,1,prices,dp);
            profit = Math.max(sell,skip);
        }

        return dp[index][count][buy] = profit;
    }
}