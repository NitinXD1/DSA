class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        st.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]){
                ans[0] = nums[i];
            }
            st.add(nums[i]);
        }

        int cnt = 1;
        for(int i:nums){
            if(!st.contains(cnt)){
                ans[1] = cnt;
                break;
            }
            cnt++;
        }

        return ans;
    }
}