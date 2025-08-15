class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> dict = new HashSet<>(wordDict);

        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int end = 0; end <= n; end++) {
            dp[n][end] = (end == n);
        }

        for (int start = n - 1; start >= 0; start--) {
            for (int end = n; end >= 0; end--) {

                boolean leave = dp[start + 1][end];
                boolean take = false;

                if (end <= start && dict.contains(s.substring(end, start + 1))) {
                    take = dp[start + 1][start + 1];
                }

                dp[start][end] = leave || take;
            }
        }

        return dp[0][0];
    }
}
