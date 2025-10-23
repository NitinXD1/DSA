class Solution {
    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        int n = grid.length; int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});
                }
                else if(grid[i][j] == 1)cnt++;
            }
        }

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0}; 

        int max = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            max = Math.max(max,time);

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjC < m && adjR < n && adjC >= 0 && grid[adjR][adjC] == 1){
                    cnt--;
                    grid[adjR][adjC] = 2;
                    q.offer(new int[]{adjR,adjC,time+1});
                }
            }
        }

        return cnt == 0 ? max : -1;
    }
}