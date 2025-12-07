class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long s=0;

        for(int i=0;i<n;i++){
            int small=nums[i];
            int large=nums[i];

            for(int j=i;j<n;j++){
                small=Math.min(small,nums[j]);
                large=Math.max(large,nums[j]);

                s+=(large-small);
            }


        }

        return s;
    }
}
