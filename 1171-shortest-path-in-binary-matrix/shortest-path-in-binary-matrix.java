class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)return -1;
        int n = grid.length; int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        pq.offer(new int[]{0,0,1});

        int[] drow = {0,1,0,-1,1,-1,1,-1};
        int[] dcol = {1,0,-1,0,1,-1,-1,1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int s = curr[2];

            if(grid[r][c] == 1)continue;

            grid[r][c] = 1;

            if(r == n-1 && c == m-1)return s;

            for(int i=0;i<8;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && grid[adjR][adjC] == 0){
                    pq.offer(new int[]{adjR,adjC,s+1});
                }
            }

        }
        return -1;
    }
}