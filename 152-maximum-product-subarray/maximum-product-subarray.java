class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int ans = nums[0];

        for(int i=1;i<nums.length;i++){
            int temp = currMax;
            currMax = Math.max(nums[i],Math.max(currMin * nums[i] , currMax * nums[i]));
            currMin = Math.min(nums[i],Math.min(currMin * nums[i] , temp * nums[i]));       
            ans = Math.max(ans,currMax);
        }

        return ans;
    }
}