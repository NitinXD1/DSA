class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0,0});

        int[] drow = {0,0,-1,-1,-1,1,1,1};
        int[] dcol = {1,-1,-1,0,1,-1,0,1};

        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            cnt++;

            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(vis[r][c])continue;
                vis[r][c] = true;

                if(r== n-1 && c == n-1)return cnt;

                for(int j=0;j<8;j++){
                    int adjR = r + drow[j];
                    int adjC = c + dcol[j];
                    
                    if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && !vis[adjR][adjC] && grid[adjR][adjC] == 0){
                        q.offer(new int[]{adjR,adjC});
                    }
                }
            }
            
        }

        return -1;
    }
}