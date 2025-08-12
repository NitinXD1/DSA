class Solution {
    int mod = 1000000007;

    public int numberOfWays(int n, int x) {
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i=1;i<=n;i++){
            int[] temp = new int[n+1];
            for(int j=0;j<=n;j++){
                int leave = dp[j];
                int take = 0;
                if(j - Math.pow(i,x) >= 0){
                    take = dp[j - (int)Math.pow(i,x)];
                }

                temp[j] = (leave + take) % mod;
            }
            dp = temp;
        }

        return dp[n];
    }
}