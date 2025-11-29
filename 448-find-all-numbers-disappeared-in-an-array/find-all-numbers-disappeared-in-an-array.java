class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length; 
        int[] hash = new int[n+1];

        for(int i:nums)hash[i]++;

        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(hash[i] == 0)ans.add(i);
        }

        return ans;
    }
}