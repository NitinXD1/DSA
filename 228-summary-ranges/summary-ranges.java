class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;

        if(n == 0)return ans;

        int prev = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i-1] + 1 != nums[i]){
                if(prev != nums[i-1]){
                    ans.add(prev +"->" + nums[i-1]);
                }
                else{
                    ans.add(String.valueOf(prev));
                }
                prev = nums[i];
            }
        }

        if(prev == nums[n-1]){
            ans.add(String.valueOf(prev));
        }
        else{
            ans.add(prev +"->" + nums[n-1]);
        }

        return ans;
    }
}