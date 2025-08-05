class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] used = new boolean[10];

        List<List<Integer>> ans = new ArrayList<>();

        helper(1,ans,new ArrayList<>(),k,n,used);

        List<List<Integer>> main = new ArrayList<>(ans);

        return main;
    }

    public void helper(int curr,List<List<Integer>> ans,List<Integer> currLs,int k,int n,boolean[] used){
        if(k == 0){
            if(n == 0){
                ans.add(new ArrayList<>(currLs));
                return;
            }
        }


        for(int i=curr;i<10;i++){
            if(!used[i]){
                
                used[i] = true;
                currLs.add(i);

                helper(i+1,ans,currLs,k-1,n-i,used);
                
                currLs.remove(currLs.size()-1);
                used[i] = false;
            }
        }
    }
}