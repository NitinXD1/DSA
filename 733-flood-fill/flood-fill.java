class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        int n = image.length; int m = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{sr,sc});

        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if(image[r][c] == color)continue;
            image[r][c] = color;

            for(int i=0;i<4;i++){
                int adjR = r + drow[i];
                int adjC = c + dcol[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && image[adjR][adjC] == startColor){
                    q.offer(new int[]{adjR,adjC});
                }
            }
        }

        return image;
    }
}