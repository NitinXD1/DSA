class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[n-1][1] = 0; 
        dp[n-1][0] = Math.max(prices[n-1]-fee,0);

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<2;j++){
                int skip = dp[i+1][j];
                int profit = 0;

                if(j==1){
                    int invest = -prices[i] + dp[i+1][0];
                    profit = Math.max(invest,skip); 
                }
                else{
                    int sell = prices[i] - fee + dp[i+1][1];
                    profit = Math.max(sell,skip);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }
}