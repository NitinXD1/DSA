class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[n] = true;

        for (int start = n - 1; start >= 0; start--) {
            boolean[] temp = new boolean[n+1];
            for (int end = n; end >= 0; end--) {

                boolean leave = dp[end];
                boolean take = false;

                if (end <= start && dict.contains(s.substring(end, start + 1))) {
                    take = dp[start + 1];
                }

                temp[end] = leave || take;
            }

            dp = temp;
        }

        return dp[0];
    }
}
