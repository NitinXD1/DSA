class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int ans = 0, count = 0;

        for (int num : nums) {
            if (num == max) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }

        return ans;
    }
}