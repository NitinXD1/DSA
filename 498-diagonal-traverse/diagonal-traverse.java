class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[0];
        
        List<List<Integer>> ls = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0;i<n;i++){
            List<Integer> r = new ArrayList<>();
            for(int k=0; k<=i && k<m; k++){
                r.add(mat[i-k][k]);
            }
            ls.add(r);
        }

        for(int j=1;j<m;j++){
            int i = n-1;
            List<Integer> r = new ArrayList<>();
            int k = 0;
            while(i-k >= 0 && j+k < m){
                r.add(mat[i-k][j+k]);
                k++;
            }
            ls.add(r);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<ls.size();i++){
            List<Integer> curr = ls.get(i);
            if(i % 2 != 0){
                Collections.reverse(curr);
            }
            ans.addAll(curr);
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}
