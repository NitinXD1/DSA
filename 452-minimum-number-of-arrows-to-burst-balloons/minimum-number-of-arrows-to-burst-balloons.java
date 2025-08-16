class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Integer.compare(a[0],b[0]));
        
        int en = points[0][1];
        int cnt = 0;
        int i=1;

        while(i < points.length){
            if(points[i][0] > en){
                cnt++;
                en = points[i][1];
            }

            en = Math.min(en,points[i][1]);
            i++;
        }

        return cnt + 1;
    }
}