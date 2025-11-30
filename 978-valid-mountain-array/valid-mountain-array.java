class Solution {
    public boolean validMountainArray(int[] nums) {
        int i = 1;
        int n = nums.length;
        while(i < n && nums[i] > nums[i-1]){
            i++;
        }

        if(i == n || i == 1)return false;

        while(i < n && nums[i] < nums[i-1]){
            i++;
        }

        return i == n ? true : false;
    }
}