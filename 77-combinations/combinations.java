class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,k,n,new ArrayList<>(),ans);
        return ans;
    }

    public void helper(int index,int k,int n,List<Integer> curr,List<List<Integer>> st){
        if(k == 0){
            st.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index+1;i<=n;i++){
            curr.add(i);
            helper(i,k-1,n,curr,st);
            curr.remove(curr.size()-1);
        }
    }
}