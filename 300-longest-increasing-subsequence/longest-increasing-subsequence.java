class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int[] i:dp)Arrays.fill(i,-1);
        
        return helper(0,-1,nums,dp);
    }

    public int helper(int index,int prev,int[] nums,int[][] dp){
        if(index == nums.length)return 0;

        if(dp[index][prev+1] != -1)return dp[index][prev+1];

        int skip = helper(index+1,prev,nums,dp);
        int take = 0;
        if(prev == -1 || nums[prev] < nums[index]){
            take = 1 + helper(index+1,index,nums,dp); 
        }

        return dp[index][prev+1] = Math.max(skip,take);
    }
}