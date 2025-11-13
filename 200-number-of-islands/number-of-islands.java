class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length; int m = grid[0].length; 
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    fill(i,j,grid,n,m);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void fill(int row,int col,char[][] grid,int n,int m){
        grid[row][col] = '0';

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        for(int i = 0;i<4;i++){
            int adjRow = row + drow[i];
            int adjCol = col + dcol[i];

            if(adjRow >= 0 && adjCol >= 0 && adjRow < n && adjCol < m && grid[adjRow][adjCol] == '1'){
                fill(adjRow,adjCol,grid,n,m);
            }
        }
        
    }
}