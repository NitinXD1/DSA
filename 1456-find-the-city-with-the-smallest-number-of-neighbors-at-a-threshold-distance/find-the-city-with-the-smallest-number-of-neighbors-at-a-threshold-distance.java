class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int[][] mat = new int[n][n];

        for(int[] i:mat){
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        for(int[] i:edges){
            mat[i[0]][i[1]] = i[2];
            mat[i[1]][i[0]] = i[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE){
                        mat[i][j] = Math.min(mat[i][j],mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        int ans = 0;
        int ansCnt = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i != j){
                    if(mat[i][j] <= t){
                        cnt++;
                    }
                }
            }
            
            if(cnt <= ansCnt){
                ans = i;
                ansCnt = cnt;
            }
        }

        return ans;
    }
}