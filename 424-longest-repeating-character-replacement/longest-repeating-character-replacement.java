class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        int left = 0;
        int right = 0;
        int[] hash = new int[26];
        int maxf = 0;

        while(right < n){
            hash[s.charAt(right) - 'A']++;
            maxf = Math.max(maxf,hash[s.charAt(right) - 'A']);

            while((right - left) + 1 - maxf > k){
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            if((right - left) + 1 - maxf <= k){
                ans = Math.max(ans,(right - left)+1);
            }

            right++;
        }

        return ans;
    }
}