class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0; int n = nums.length;

        int curr = 0;
        int ans = Integer.MAX_VALUE;

        while(right < n){
            curr += nums[right];
            
            while(curr >= target){
                ans = Math.min(ans , right - left + 1);
                curr -= nums[left];
                left++;
            }

            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}