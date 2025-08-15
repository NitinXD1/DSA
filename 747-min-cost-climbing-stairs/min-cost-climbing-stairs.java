class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = cost[0];
        int curr = cost[1];

        int n = cost.length;

        for(int i=2;i<n;i++){
            int next = cost[i] + Math.min(prev,curr);
            prev = curr;
            curr = next;
        }

        return Math.min(curr,prev);
    }
}