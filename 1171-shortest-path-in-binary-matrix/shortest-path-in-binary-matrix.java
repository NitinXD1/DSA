class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,1});

        int[] drow = {0,1,0,-1,-1,-1,1,1};
        int[] dcol = {1,0,-1,0,-1,1,1,-1};

        int[][] dist = new int[n][n];
        for(int[] i:dist)Arrays.fill(i,Integer.MAX_VALUE);
        dist[0][0] = 1;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int s = curr[2];

            if(r == n-1 && c == n-1)return s;
            if(dist[r][c] < s)continue;

            for(int i=0;i<8;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];
                
                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && grid[adjR][adjC] == 0 && s + 1 < dist[adjR][adjC]){
                    pq.offer(new int[]{adjR,adjC,s+1});
                    dist[adjR][adjC] = s+1;
                }
            }
        }

        return -1;
    }
}