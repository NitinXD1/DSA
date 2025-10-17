class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length; int m = isWater[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j] == 1){
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        
        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int s = curr[2];

            if(vis[r][c])continue;
            
            isWater[r][c] = s;
            
            vis[r][c] = true;


            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && !vis[adjR][adjC]){
                    q.offer(new int[]{adjR,adjC,s+1});
                }
            }
        }

        return isWater;
    }
}