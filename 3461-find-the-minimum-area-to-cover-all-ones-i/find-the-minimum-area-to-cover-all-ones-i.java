class Solution {
    public int minimumArea(int[][] grid) {
        int up = Integer.MAX_VALUE;
        int down = 0;
        int left = Integer.MAX_VALUE;
        int right = 0;

        int n = grid.length; int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    left = Math.min(left,j);
                    up = Math.min(up,i);
                    down = Math.max(down,i);
                    right = Math.max(right,j);
                }
            }
        }

        return (right - left + 1) * (down - up + 1);
    }
}