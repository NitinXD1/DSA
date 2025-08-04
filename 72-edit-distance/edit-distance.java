class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(); int m = word2.length();

        int[] dp = new int[m+1];

        for(int j=0;j<=m;j++){
            dp[j] = j;
        }

        for(int i=1;i<=n;i++){
            int[] temp = new int[m+1];
            temp[0] = i;
            for(int j=1;j<=m;j++){
                
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    temp[j] = dp[j-1];
                }
                else{
                    int replace = 1 + dp[j-1];
                    int insert = 1 + temp[j-1];
                    int delete = 1 + dp[j];

                    temp[j] = Math.min(insert,Math.min(replace,delete));
                }
            }
            dp = temp;
        }

        return dp[m];
    }
}