class Solution {
    public int countSquares(int[][] matrix) {
        int cnt = 0;
        int n = matrix.length; int m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                int val = 0;
                if(matrix[i][j] == 1){
                    int up = i == 0 ? 0 : matrix[i-1][j];
                    int left = j == 0 ? 0 : matrix[i][j-1];
                    int diag = i >= 1 && j >= 1 ? matrix[i-1][j-1] : 0;

                    val = Math.min(up,Math.min(left,diag)) + 1;
                    matrix[i][j] = val;
                }

                cnt += val;
            }
        }

        return cnt;
    }
}