class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n+1][n+1];

        for(int[] i:queries){
            int r1 = i[0];
            int c1 = i[1];
            int r2 = i[2];
            int c2 = i[3];

            ans[r1][c1] += 1;
            ans[r1][c2+1] -=1;
            ans[r2+1][c1] -=1;
            ans[r2+1][c2+1] +=1;
        }

        for(int[] r:ans){
            for(int j=1;j<n;j++){
                r[j] = r[j-1] + r[j];
            }
        }

        for(int j=0;j<n;j++){
            for(int i=1;i<n;i++){
                ans[i][j] = ans[i-1][j] + ans[i][j];
            }
        }

        int[][] trimmed = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                trimmed[i][j] = ans[i][j];
            }
        }

        return trimmed;
    }
}