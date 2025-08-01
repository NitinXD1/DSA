class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)return -1;
        int n = grid.length; int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        int[][] distance = new int[n][m];

        for(int[] i:distance){
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        distance[0][0] = 0;

        pq.offer(new int[]{0,0,1});

        int[] drow = {0,1,0,-1,1,-1,1,-1};
        int[] dcol = {1,0,-1,0,1,-1,-1,1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for(int i=0;i<8;i++){
                int newR = r + drow[i];
                int newC = c + dcol[i];

                if (r == n - 1 && c == n - 1) return dist;

                if(newR >= 0 && newR < n && newC >=0 && newC < m && grid[newR][newC] == 0 && distance[newR][newC] > dist + 1){                 
                    distance[newR][newC] = dist+1;
                    pq.offer(new int[]{newR,newC,dist+1});
                }
            }

        }
        return distance[n-1][n-1] == Integer.MAX_VALUE ? -1 : distance[n-1][n-1];
    }
}