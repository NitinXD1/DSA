class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] i:dp)Arrays.fill(i,-1);

        int[] ans = new int[]{0,0};

        helper(0,s.length()-1,s,dp,ans);

        return s.substring(ans[0],ans[1]+1);
    }

    public void helper(int i,int j,String s,int[][] dp,int[] ans){
        if(i>j) return;

        if(dp[i][j] != -1) return;

        if(check(i,j,s)){
            int gap = j-i+1;
            if(gap>ans[1]-ans[0]){
                ans[0] = i;
                ans[1] = j;
            }
            dp[i][j] = 1;
            return;
        }

        helper(i+1,j,s,dp,ans);
        helper(i,j-1,s,dp,ans);

        dp[i][j] = 0;
    }

    public boolean check(int s,int e,String str){
        while(s<e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++; e--;
        }
        return true;
    }
}