class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        int n = maze.length;
        int m = maze[0].length;

        q.offer(new int[]{entrance[0],entrance[1],0});

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        boolean[][] vis = new boolean[n][m];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];

            if(vis[r][c])continue;

            vis[r][c] = true;

            if ((r != entrance[0] || c != entrance[1]) && (r == 0 || c == 0 || r == n - 1 || c == m - 1)) {
                return steps;
            }

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && maze[adjR][adjC] == '.' && !vis[adjR][adjC]){
                    q.offer(new int[]{adjR,adjC,steps+1});
                }
            }
        }

        return -1;
    }
}