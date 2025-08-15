class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] i:dp)Arrays.fill(i,-1);

        boolean[][] pd = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tempS = i;
                int tempE = j;
                boolean isPal = true;
                while (tempS < tempE) {
                    if (s.charAt(tempS) != s.charAt(tempE)) {
                        isPal = false;
                        break;
                    }
                    tempS++;
                    tempE--;
                }
                pd[i][j] = isPal;
            }
        }


        return helper(0,0,s,dp,pd) - 1;
    }

    public int helper(int st,int en,String s,int[][] dp,boolean[][] pd){
        if(st == s.length()){
            return en == s.length() ? 0 : (int)(1e9);
        }

        if(dp[st][en] != -1)return dp[st][en];

        int leave = helper(st+1,en,s,dp,pd);
        int take = (int)(1e9);
        if(pd[en][st]){
            take = 1 + helper(st+1,st+1,s,dp,pd);
        }

        return dp[st][en] = Math.min(leave,take);
    }
}