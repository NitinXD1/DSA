class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer> hash = new HashMap<>();
        int n = stones.length;

        for(int i=0;i<n;i++){
            hash.put(stones[i],i);
        }

        if(stones[1] != 1)return false;

        int[][] dp = new int[n][2000];

        for(int[] i:dp)Arrays.fill(i,-1);

        return helper(1,1,stones,hash,dp);
    }
    
    public boolean helper(int index,int last,int[] stones,HashMap<Integer,Integer> hash,int[][] dp){
        if(index == stones.length-1)return true;

        if(dp[index][last] != -1)return dp[index][last] == 1 ? true : false;

        boolean ans = false;

        for(int i=-1;i<=1;i++){
            if(last + i <= 0)continue;
            int key = stones[index] + last + i;
            boolean curr = false;
            if(hash.containsKey(key)){
                int newIndex = hash.get(key);
                curr = helper(newIndex,last+i,stones,hash,dp);
                if(curr)ans = true;
            }
        }

        if(ans)dp[index][last] = 1;
        else dp[index][last] = 0;

        return ans;
    }
}