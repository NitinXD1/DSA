class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return new int[0];
        
        List<Integer> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        boolean flag = false;

        for(int i=0;i<n;i++){
            List<Integer> r = new ArrayList<>();
            for(int k=0; k<=i && k<m; k++){
                r.add(mat[i-k][k]);
            }
            
            if(!flag){
                flag = true;
            }
            else{
                flag = false;
                Collections.reverse(r);
            }

            ans.addAll(r);
        }

        for(int j=1;j<m;j++){
            
            int i = n-1;
            List<Integer> r = new ArrayList<>();
            int k = 0;

            while(i-k >= 0 && j+k < m){
                r.add(mat[i-k][j+k]);
                k++;
            }
            
            if(!flag){
                flag = true;
            }
            else{
                flag = false;
                Collections.reverse(r);
            }

            ans.addAll(r);
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}
