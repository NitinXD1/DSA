class Solution {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int cnt = 0;

        while(r < n-1){
            int max = 0;

            for(int i=l;i<=r;i++){
                max = Math.max(max,nums[i] + i);
            }

            l = r+1;
            r = max;
            cnt++;
        }

        return cnt;
    }
}