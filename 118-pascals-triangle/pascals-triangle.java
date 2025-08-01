class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> r = new ArrayList<>();

            for(int j=0;j<=i;j++){
                if(j == 0 || j == i){
                    r.add(1);
                }
                else{
                    int up = ans.get(i-1).get(j);
                    int left = ans.get(i-1).get(j-1);

                    r.add(up+left);
                }
            }

            ans.add(r);
        }

        return ans;
    }
}