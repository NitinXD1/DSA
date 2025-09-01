class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hash = new HashMap<>();

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,hash,new ArrayList<>(),ans);
        return ans;
    }

    public void helper(int[] nums,HashMap<Integer,Integer> hash,List<Integer> curr,List<List<Integer>> ans){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
        }

        for(int i=0;i<nums.length;i++){
            if(!hash.containsKey(nums[i])){
                curr.add(nums[i]);
                hash.put(nums[i],1);
                helper(nums,hash,curr,ans);
                curr.remove(curr.size()-1);
                hash.remove(nums[i]);
            }
        }
    }
}