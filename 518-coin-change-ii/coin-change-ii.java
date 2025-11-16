class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(0,amount,coins,dp);
    }

    public int helper(int index,int amount,int[] coins,int[][] dp){
        if(amount == 0)return 1;
        if(index == coins.length)return 0;

        if(dp[index][amount] != -1)return dp[index][amount];

        int skip = helper(index+1,amount,coins,dp);
        int take = amount >= coins[index] ? helper(index,amount-coins[index],coins,dp) : 0;

        return dp[index][amount] = skip + take;
    }
}