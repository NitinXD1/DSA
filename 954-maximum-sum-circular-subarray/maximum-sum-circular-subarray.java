class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = findMinKadane(nums);
        int max = findMaxKadane(nums);
        int neg = Integer.MIN_VALUE;
        int total = 0;

        for(int i:nums){
            neg = Math.max(neg,i);
            total += i;
        }

        if(neg < 0)return neg;

        return Math.max(total - min,max);
    }

    public int findMinKadane(int[] nums) {
        int min = nums[0];
        int total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (total > 0) {
                total = 0;
            }
            total += nums[i];
            min = Math.min(min, total);
        }

        return min;
    }

    public int findMaxKadane(int[] nums){
        int max = nums[0];
        int total = 0;

        for(int i:nums){
            if(total < 0){
                total = 0;
            }

            total += i;
            max = Math.max(max,total);
        }

        return max;
    }
}