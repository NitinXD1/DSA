class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] ans = new int[n];
        Arrays.sort(potions);

        for(int i=0;i<n;i++){
            int left = 0;
            int right = potions.length-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                long val = (long)potions[mid] * spells[i];
                if(val >= success){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }

            ans[i] = potions.length - (right + 1);
        }

        return ans;
    }
}