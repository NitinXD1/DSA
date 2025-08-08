class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int freq = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[index-1]){
                freq++;
                if(freq <= 2){
                    nums[index] = nums[i];
                    index++;
                }
            }
            else{
                nums[index] = nums[i];
                index++;
                freq = 1;
            }
        }

        return index;
    }
}