class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;

        while(right < n){
            if(nums[right] == 0){
                left = right;
                while(right < n && nums[right] == 0){
                    cnt += (right - left)+1;
                    right++;
                }
                
                if(right == n)break;
            }
            right++;
        }

        return cnt;
    }
}