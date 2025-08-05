class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);

        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(mid,piles,h)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return left;
    }

    public int max(int[] piles){
        int ans = 0;
        for(int i:piles)ans = Math.max(i,ans);
        return ans;
    }

    public boolean check(int mid,int[] piles,int h){
        int cnt = 0;

        for(int i:piles){
            cnt += Math.ceil((double)i/(double)mid);
        }

        return cnt <= h;
    }
}