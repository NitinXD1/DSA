class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 && j == 0)continue;

                int left = j == 0 ? (int)(1e9) : dp[i][j-1];  
                int up = i == 0 ? (int)(1e9) : dp[i-1][j];

                dp[i][j] = Math.min(left,up) + grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }
}