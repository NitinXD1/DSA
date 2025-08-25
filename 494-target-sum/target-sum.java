class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0; int n = nums.length;
        for(int i:nums)sum+=i;

        if(sum < Math.abs(target))return 0;

        int[][] dp = new int[n+1][sum * 2 + 1];

        dp[n][target+sum] = 1;

        for(int i=n-1;i>=0;i--){
            for(int j=-sum;j<=sum;j++){
                int ways = 0;

                if (j + nums[i] + sum <= 2 * sum)
                    ways += dp[i + 1][j + nums[i] + sum];

                if (j - nums[i] + sum >= 0)
                    ways += dp[i + 1][j - nums[i] + sum];

                dp[i][j + sum] = ways;
            }
        }

        return dp[0][sum];
    }
}