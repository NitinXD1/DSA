class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return 0;

        int[][] dp = new int[n][m];

        dp[n-1][m-1] = 1;

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i == n-1 && j == m-1)continue;

                int down = i == n-1 || grid[i+1][j] == 1 ? 0 : dp[i+1][j];
                int right = j == m-1 || grid[i][j+1] == 1 ? 0 : dp[i][j+1];

                dp[i][j] = down + right; 
            }
        }

        return dp[0][0];
    }
}