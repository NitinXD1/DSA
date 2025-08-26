class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        float c = 0;

        for(int[] i:dimensions){
            float temp = (float)Math.sqrt(i[0]*i[0] + i[1]*i[1]);
            
            if(temp > c){
                c = temp;
                ans = i[0] * i[1];
            }
            else if(temp == c){
                ans = Math.max(ans,i[0] * i[1]);
            }
        }

        return ans;
    }
}