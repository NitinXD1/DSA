class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length; int m = grid[0].length;

        int cnt = 0;

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
            int s = curr[2];

            max = Math.max(s,max);

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && grid[adjR][adjC] == 1){        
                    grid[adjR][adjC] = 2;
                    q.offer(new int[]{adjR,adjC,s+1});
                    cnt--;
                }
            }
        }

        return cnt == 0 ? max : -1;
    }
}