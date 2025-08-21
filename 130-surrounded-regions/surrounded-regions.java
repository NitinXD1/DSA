class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && board[i][j] == 'O'){
                    q.offer(new int[]{i,j});
                }
            }
        }

        boolean[][] vis = new boolean[n][m];

        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            vis[r][c] = true;

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && !vis[adjR][adjC] && board[adjR][adjC] == 'O'){
                    q.offer(new int[]{adjR,adjC});
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}