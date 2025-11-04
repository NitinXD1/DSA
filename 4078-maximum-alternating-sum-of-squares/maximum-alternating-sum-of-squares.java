class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] < 0)nums[i] = -nums[i];
        }

        Arrays.sort(nums);
        rev(nums);

        long ans = 0;

        int i = 0;
        int j = n % 2 == 0 ? n/2 : (n/2) + 1;

        while(j < n){
            ans += (nums[i] * nums[i]) - (nums[j] * nums[j]);
            i++;
            j++;
        }

        if(n % 2 != 0)ans += (nums[i] * nums[i]);

        return ans;
    }

    public void rev(int[] nums){
        int i = 0;
        int j = nums.length-1;

        while(i < j){
            int a = nums[i];
            nums[i] = nums[j];
            nums[j] = a;
            i++;
            j--;
        }

    }
}