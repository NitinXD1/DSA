class Solution {
    public boolean canJump(int[] nums) {
        int last = nums[0];

        if(nums.length == 1)return true;

        int i=1;

        while(i <= last){
            if(i == nums.length-1)return true;
            last = Math.max(i + nums[i],last);
            i++;
        }

        return false;
    }
}