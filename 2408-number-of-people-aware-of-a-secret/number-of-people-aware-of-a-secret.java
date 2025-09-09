class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[][] dp = new long[n+1][forget];
        int mod = (int)(1e9+7);

        dp[1][0] = 1;

        for (int day = 1; day < n; day++) {
            for (int k = 0; k < forget; k++) {
                long count = dp[day][k];
                if (count == 0) continue;

                // next day progression (aging)
                if (k + 1 < forget) {
                    dp[day + 1][k + 1] = (dp[day + 1][k + 1] + count) % mod;
                }

                // sharing new people
                if (k + 1 >= delay && k + 1 < forget) {
                    dp[day + 1][0] = (dp[day + 1][0] + count) % mod;
                }
            }
        }


        long ans = 0;
        for(int k=0;k<forget;k++){
            ans = (ans + dp[n][k]) % mod; 
        }

        return (int) ans;
    }
}