class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;

        boolean[][] vis = new boolean[n][n];
        // for(int[] i:vis)Arrays.fill(i,Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});

        int[] drow = {1,-1,-1,1,0,-1,0,1};
        int[] dcol = {1,-1,1,-1,1,0,-1,0};

        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0;k<size;k++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(r == n-1 && c == n-1)return cnt;

                if(vis[r][c])continue;
                
                vis[r][c] = true;

                for(int i=0;i<8;i++){
                    int adjR = r + drow[i];
                    int adjC = c + dcol[i];

                    if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && grid[adjR][adjC] == 0){
                        q.offer(new int[]{adjR,adjC});
                    }
                }
            }
            cnt++;
        }

        return -1; 
    }
}