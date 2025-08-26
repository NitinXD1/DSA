class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;

        int target = sum / k;
        boolean[] vis = new boolean[nums.length];

        return backtrack(nums, vis, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] vis, int k, int start, int currSum, int target) {
        if (k == 1) return true; // last subset must work

        if (currSum == target) {
            return backtrack(nums, vis, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (vis[i] || currSum + nums[i] > target) continue;

            vis[i] = true;
            if (backtrack(nums, vis, k, i + 1, currSum + nums[i], target)) return true;
            vis[i] = false;
        }
        return false;
    }
}
