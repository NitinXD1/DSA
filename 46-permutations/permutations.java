class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hash = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,hash,new ArrayList<>(),ans);
        return ans;
    }

    public void helper(int[] nums,HashSet<Integer> hash,List<Integer> curr,List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
        }

        for(int i=0;i<nums.length;i++){
            if(!hash.contains(nums[i])){
                curr.add(nums[i]);
                hash.add(nums[i]);
                helper(nums,hash,curr,ans);
                curr.remove(curr.size()-1);
                hash.remove(nums[i]);
            }
        }
    }
}