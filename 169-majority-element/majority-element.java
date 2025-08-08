class Solution {
    public int majorityElement(int[] nums) {
        int prev = nums[0];
        int freq = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == prev){
                freq++;
            }
            else{
                freq--;
                if(freq == 0){
                    prev = nums[i];
                    freq = 1;
                }
            }
        }

        return prev;
    }
}