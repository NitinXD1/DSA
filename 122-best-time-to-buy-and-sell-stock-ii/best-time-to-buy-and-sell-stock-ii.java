class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];

        for(int i=n-1;i>=0;i--){
            int[] temp = new int[2];
            for(int j=0;j<2;j++){
                int skip = dp[j];

                int max = 0;

                if(j == 1){
                    int invest = -prices[i] + dp[0];
                    max = Math.max(invest,skip);
                }
                else{
                    int sell = prices[i] + dp[1];
                    max = Math.max(sell,skip);
                }

                temp[j] = max;
            }

            dp = temp;
        }

        return dp[1];
    }
}