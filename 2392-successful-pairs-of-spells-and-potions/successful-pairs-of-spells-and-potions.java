class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = bs(spells[i],potions,success);
        }
        return ans;
    }

    public int bs(int val,int[] potions,long success){
        int left = 0;
        int right = potions.length-1;

        int n = potions.length;

        int ans = -1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if((long)potions[mid] * val >= success){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return ans == -1 ? 0 : n - ans;
    }
}