class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int n = prices.length;

        int max = 0;
        for(int i=1;i<n;i++){
            max = Math.max(max,prices[i] - buy);
            buy = Math.min(prices[i],buy);
        }

        return max;
    }
}