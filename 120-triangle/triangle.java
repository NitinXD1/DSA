class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int[] i:dp)Arrays.fill(i,(int)(1e9));

        dp[0][0] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            for(int j=0;j<triangle.get(i).size();j++){

                int left = Integer.MAX_VALUE;
                if(j >= 1)left = dp[i-1][j-1];
                int up = dp[i-1][j];

                dp[i][j] = Math.min(left,up) + triangle.get(i).get(j);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}