class Solution {
    public int maxSubArray(int[] nums) {
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(0,0,max,nums);
        return max[0];
    }

    public void helper(int index,int curr,int[] max,int[] nums){
        if(index == nums.length){
            return;
        }

        curr = Math.max(nums[index],curr+nums[index]);
        helper(index+1,curr,max,nums);
        max[0] = Math.max(curr,max[0]);
    }
}