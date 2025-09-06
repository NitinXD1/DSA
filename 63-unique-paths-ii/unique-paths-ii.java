class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return 0;

        int[][] dp = new int[n][m];
        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,n,m,grid,dp);
    }

    public int helper(int r,int c,int n,int m,int[][] grid,int[][] dp){
        if(r == n-1 && c == m-1)return 1;
        if(r == n || c == m)return 0;

        if(grid[r][c] == 1)return 0;

        if(dp[r][c] != -1)return dp[r][c];

        int down = helper(r+1,c,n,m,grid,dp);
        int right = helper(r,c+1,n,m,grid,dp);

        return dp[r][c] = down + right;
    }
}