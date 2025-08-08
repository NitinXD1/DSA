class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        rev(nums,0,n-k-1);
        rev(nums,n-k,n-1);
        rev(nums,0,n-1);
    }

    public void rev(int[] nums,int st,int en){
        while(st < en){
            int temp = nums[st];
            nums[st] = nums[en];
            nums[en] = temp;
            st++;
            en--;
        }
    }
}