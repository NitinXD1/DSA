class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[] drow = {0,-1,0,1};
        int[] dcol = {1,0,-1,0};

        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});

        int[][] diff = new int[n][m];
        for(int[] i:diff)Arrays.fill(i,Integer.MAX_VALUE);
        diff[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(r == n-1 && c == m-1){
                return d;
            }

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m){
                    int cost = Math.abs(heights[r][c] - heights[adjR][adjC]);

                    int newCost = Math.max(cost,d);

                    if(newCost < diff[adjR][adjC]){
                        diff[adjR][adjC] = newCost;
                        pq.offer(new int[]{adjR,adjC,newCost});
                    }
                }
            }
        }

        return diff[n-1][m-1];
    }
}