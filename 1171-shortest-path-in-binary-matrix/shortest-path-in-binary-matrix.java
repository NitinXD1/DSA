class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;

        int[][] dist = new int[n][n];
        for(int[] i:dist)Arrays.fill(i,Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        q.offer(new int[]{0,0,1});

        int[] drow = {1,-1,-1,1,0,-1,0,1};
        int[] dcol = {1,-1,1,-1,1,0,-1,0};

        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(r == n-1 && c == n-1)return d;

            if(dist[r][c] < d)continue;

            for(int i=0;i<8;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && grid[adjR][adjC] == 0){
                    if(d + 1 < dist[adjR][adjC]){
                        dist[adjR][adjC] = d+1;
                        q.offer(new int[]{adjR,adjC,d+1});
                    }
                }
            }
        }

        return -1; 
    }
}