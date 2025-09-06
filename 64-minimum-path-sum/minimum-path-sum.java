class Solution {
    public int minPathSum(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        int n = grid.length;
        int m = grid[0].length;
        
        pq.offer(new int[]{0,0,grid[0][0]});

        boolean[][] vis = new boolean[n][m];

        int[] drow = {1,0};
        int[] dcol = {0,1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            if(vis[r][c])continue;
            vis[r][c] = true;

            if(r == n-1 && c == m-1)return cost;

            for(int i=0;i<2;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && !vis[adjR][adjC]){
                    int newCost = cost+grid[adjR][adjC];
                    pq.offer(new int[]{adjR,adjC,newCost});
                }
            }
        }
        
        return -1;
    }
}