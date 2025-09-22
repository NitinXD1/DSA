class Solution {
    public int numberOfSubstrings(String s) {
        return helper(s,3) - helper(s,2);
    }

    public int helper(String s,int k){
        int[] hash = {0,0,0};
        int n = s.length() , left = 0 , right = 0 , cnt = 0 , ans = 0; 

        if(k < 0)return 0;

        while(right < n){
            if(hash[s.charAt(right) - 'a'] == 0)cnt++;
            hash[s.charAt(right) - 'a']++;

            while(cnt > k){
                hash[s.charAt(left) - 'a']--;
                if(hash[s.charAt(left) - 'a'] == 0)cnt--;
                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}