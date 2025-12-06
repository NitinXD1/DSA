class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        boolean[][] vis = new boolean[n][m];

        pq.offer(new int[]{0,0,0});

        int[] drow = {0,0,1,-1};
        int[] dcol = {1,-1,0,0};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            System.out.println(e);

            if(vis[r][c])continue;

            if(r == n-1 && c == m-1)return e;

            vis[r][c] = true;

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjC < m && adjC >= 0 && adjR < n && !vis[adjR][adjC]){       
                    int nextE = Math.max(e,Math.abs(grid[r][c] - grid[adjR][adjC]));
                    pq.offer(new int[]{adjR,adjC,nextE});
                }
            }
        }

        return -1;
    }
}