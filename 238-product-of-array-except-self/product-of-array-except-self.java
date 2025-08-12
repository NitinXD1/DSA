class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroesCnt = 0;
        int prod = 1;

        for(int i:nums){
            if(i == 0){
                zeroesCnt++;
            }
            else{
                prod *= i;
            }
        }

        int n = nums.length;

        if(zeroesCnt >= 2)return new int[n];

        for(int i=0;i<n;i++){
            if(zeroesCnt == 1){
                if(nums[i] == 0){
                    nums[i] = prod;
                }
                else{
                    nums[i] = 0;
                }
            }
            else{
                nums[i] = prod / nums[i];
            }
        }

        return nums;
    }
}