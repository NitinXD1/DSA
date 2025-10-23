class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i:nums)sum+=i;

        if(sum % 2 != 0)return false;

        int target = sum/2;

        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];

        dp[0][0] = true;
        if(nums[0] <= target)dp[0][nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int j=0;j<=target;j++){
                boolean leave = dp[i-1][j];
                boolean take = j >= nums[i] ? dp[i-1][j-nums[i]] : false;
            
                dp[i][j] = leave || take;
            }
        }

        return dp[n-1][target];
    }
}