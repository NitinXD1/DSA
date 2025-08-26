class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i:stones)sum+=i;

        int target = sum/2;

        int n = stones.length;
        int[][] dp = new int[n][target+1];
        for(int[] i:dp)Arrays.fill(i,-1);

        int val = helper(0,0,target,stones,dp);

        return sum - val*2;        
    }

    public int helper(int index,int curr,int target,int[] stones,int[][] dp){
        if(index == stones.length)return curr;

        if(dp[index][curr] != -1)return dp[index][curr];

        int leave = helper(index+1,curr,target,stones,dp);
        int take = 0;
        if(curr + stones[index] <= target){
            take = helper(index+1,curr+stones[index],target,stones,dp);
        }

        return dp[index][curr] = Math.max(leave,take);
    }
}