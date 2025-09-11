class Solution {
    public int maxSubArray(int[] nums) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        helper(0, 0, ans, nums);
        return ans[0];
    }

    public void helper(int index, int curr, int[] ans, int[] nums) {
        if (index == nums.length) {
            return;
        }

        curr = Math.max(nums[index], curr + nums[index]);
        ans[0] = Math.max(ans[0], curr);

        helper(index + 1, curr, ans, nums);
    }
}
