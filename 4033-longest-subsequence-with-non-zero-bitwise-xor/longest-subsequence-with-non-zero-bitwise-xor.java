class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean isZero = true;
        for(int i:nums){
            totalXor ^= i;
            if(i != 0)isZero = false;
        }

        if(totalXor != 0 && !isZero)return nums.length;

        return isZero ? 0 : nums.length-1;
    }
}