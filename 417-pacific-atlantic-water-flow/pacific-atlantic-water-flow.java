class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length; int m = heights[0].length;
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];
        Queue<int[]> p = new LinkedList<>();
        Queue<int[]> a = new LinkedList<>();

        for(int i=0;i<n;i++){
            pacific[i][0] = true;
            p.offer(new int[]{i,0});
        }
        for(int i=0;i<m;i++){
            pacific[0][i] = true;
            p.offer(new int[]{0,i});
        }
        for(int i=0;i<m;i++){
            atlantic[n-1][i] = true;
            a.offer(new int[]{n-1,i});
        }
        for(int i=0;i<n;i++){
            atlantic[i][m-1] = true;
            a.offer(new int[]{i,m-1});
        }

        bfs(p,pacific,heights,n,m);
        bfs(a,atlantic,heights,n,m);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        return res;
    }

    public void bfs(Queue<int[]> q,boolean[][] ocean,int[][] heights,int n,int m){
        int[] drow = {0,1,0,-1};
        int[] dcol = {1,0,-1,0};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjC >= 0 && adjC < m && adjR < n && heights[adjR][adjC] >= heights[r][c] && !ocean[adjR][adjC]){
                    ocean[adjR][adjC] = true;
                    q.offer(new int[]{adjR,adjC});
                }
            }
        }
    }
}