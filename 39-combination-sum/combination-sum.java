class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        helper(0,candidates,target,new ArrayList<>(),ans);

        return ans;
    }

    public void helper(int index,int[] nums,int target,List<Integer> curr,List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(index == nums.length)return;

        for(int i=index;i<nums.length;i++){
            if(target - nums[i] >= 0){
                curr.add(nums[i]);
                helper(i,nums,target-nums[i],curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}