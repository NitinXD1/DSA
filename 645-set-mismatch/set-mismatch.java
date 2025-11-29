class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int[] hash = new int[n+1];

        for(int i:nums){
            hash[i]++;
            if(hash[i] == 2){
                ans[0] = i;
            }
        }

        for(int i=1;i<=n;i++){
            if(hash[i] == 0){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}