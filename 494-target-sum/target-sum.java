class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0; int n = nums.length;
        for(int i:nums)sum+=i;

        if(sum < Math.abs(target))return 0;

        int[][] dp = new int[n][sum * 2 + 1];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,target,sum,nums,dp);
    }

    public int helper(int index,int curr,int target,int sum,int[] nums,int[][] dp){
        if(index == nums.length){
            return curr == target ? 1 : 0;
        }

        if(dp[index][curr + sum] != -1)return dp[index][curr + sum];

        int add = helper(index+1,curr+nums[index],target,sum,nums,dp);
        int sub = helper(index+1,curr-nums[index],target,sum,nums,dp);

        return dp[index][curr + sum] = add + sub;
    }
}