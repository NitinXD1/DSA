class Solution {
    public int numSub(String s) {
        long ans = 0;
        int mod = (int)(1e9+7);

        long cnt = 0;
        for(char ch:s.toCharArray()){
            if(ch == '1'){
                cnt++;
            }
            else{
                ans = (ans + (cnt * (cnt+1))/2)%mod;
                cnt = 0;
            }
        }

        if(cnt > 0)ans = (ans + (cnt * (cnt+1))/2)%mod;

        return (int)(ans%mod);
    }
}