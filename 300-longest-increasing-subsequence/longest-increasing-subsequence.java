class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,-1,nums,dp);
    }

    public int helper(int curr,int prev,int[] nums,int[][] dp){
        if(curr == nums.length)return 0;

        if(dp[curr+1][prev+1] != -1)return dp[curr+1][prev+1];

        int skip = helper(curr+1,prev,nums,dp);
        int take = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            take = 1 + helper(curr+1,curr,nums,dp);
        }

        return dp[curr+1][prev+1] = Math.max(skip,take);
    }
}