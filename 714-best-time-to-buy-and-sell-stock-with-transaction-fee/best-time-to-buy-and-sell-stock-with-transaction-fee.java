class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];

        dp[1] = 0; 
        dp[0] = Math.max(prices[n-1]-fee,0);

        for(int i=n-2;i>=0;i--){
            int[] temp = new int[2];
            for(int j=0;j<2;j++){
                int skip = dp[j];
                int profit = 0;

                if(j==1){
                    int invest = -prices[i] + dp[0];
                    profit = Math.max(invest,skip); 
                }
                else{
                    int sell = prices[i] - fee + dp[1];
                    profit = Math.max(sell,skip);
                }

                temp[j] = profit;
            }
            dp = temp;
        }

        return dp[1];
    }
}