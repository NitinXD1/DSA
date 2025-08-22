class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(); int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        StringBuilder ans = new StringBuilder();
        while(n > 0 && m > 0){
            
            if(str1.charAt(n-1) == str2.charAt(m-1)){
                ans.append(str1.charAt(n-1));
                n--;
                m--;
            }
            else if(dp[n-1][m] >= dp[n][m]){
                ans.append(str1.charAt(n-1));
                n--;
            }
            else{
                ans.append(str2.charAt(m-1));
                m--;
            }
        }

        while(n > 0){
            ans.append(str1.charAt(n-1));
            n--;
        }

        while(m > 0){
            ans.append(str2.charAt(m-1));
            m--;
        }

        return ans.reverse().toString();
    }
}