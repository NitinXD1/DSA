class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0; int n = nums.length;

        int cnt = 0;
        while(right < n){
            if(nums[right] == 0){
                cnt++;
            }

            while(cnt > 1){
                if(nums[left] == 0)cnt--;
                left++;
            }

            max = Math.max(max,right - left);
            right++;
        }

        return max;
    }
}