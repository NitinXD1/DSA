class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,grid[0][0]});
        
        boolean[][] vis = new boolean[n][m];
        int[] drow = {0,1,0,-1};
        int[] dcol = {-1,0,1,0};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(vis[r][c])continue;
            vis[r][c] = true;

            if(r == n-1 && c == m-1)return d;

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && !vis[adjR][adjC]){
                    int adjD = grid[adjR][adjC];
                    pq.offer(new int[]{adjR,adjC,Math.max(d,adjD)});
                }
            }
        }

        return -1;
    }
}