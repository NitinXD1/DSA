class Solution {
    public void sortColors(int[] nums) {
        int low = 0; int mid = 0; int high = nums.length-1; int n = nums.length;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(low,mid,nums);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(mid,high,nums);
                high--;
            }
        }
    }

    public void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}