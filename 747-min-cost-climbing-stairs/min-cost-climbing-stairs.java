class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = cost[0];
        int curr = cost[1];

        for(int i=2;i<n;i++){
            int oneStep = curr;
            int twoStep = prev;

            prev = curr;
            curr = Math.min(oneStep,twoStep) + cost[i];
        }

        return Math.min(prev,curr);
    }
}