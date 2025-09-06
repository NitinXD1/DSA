class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,0,n,m,grid,dp);
    }

    public int helper(int r,int c,int n,int m,int[][] grid,int[][] dp){
        if(r == n-1 && c == m-1)return grid[n-1][m-1];
        if(r == n || c == m)return (int)(1e9);

        if(dp[r][c] != -1)return dp[r][c];

        int down = helper(r+1,c,n,m,grid,dp);
        int right = helper(r,c+1,n,m,grid,dp);

        return dp[r][c] = Math.min(down,right) + grid[r][c];
    }
}