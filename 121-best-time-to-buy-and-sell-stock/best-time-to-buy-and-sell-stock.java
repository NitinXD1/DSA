class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int max = 0;

        for(int i=1;i<n;i++){
            max = Math.max(prices[i] - buy,max);
            buy = Math.min(prices[i],buy);
        }

        return max;
    }
}