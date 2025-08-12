class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] suff = new int[n];

        suff[n-1] = height[n-1];

        for(int i=n-2;i>=0;i--){
            suff[i] = Math.max(suff[i+1],height[i]);
        }

        int pge = -1;
        int ans = 0;
        for(int i=0;i<n;i++){
            pge = Math.max(pge,height[i]);

            if(pge > height[i] && suff[i] > height[i]){
                ans += Math.min(pge,suff[i]) - height[i];
            }
        }

        return ans;
    }
}