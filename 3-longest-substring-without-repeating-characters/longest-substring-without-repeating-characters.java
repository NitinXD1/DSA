class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length(); 

        int[] hash = new int[126];
        int ans = 0;

        while(right < n){
            hash[s.charAt(right) - ' ']++;

            while(hash[s.charAt(right) - ' '] > 1){
                hash[s.charAt(left) - ' ']--;
                left++;
            }

            ans = Math.max(ans,right - left + 1);
            right++;
        }

        return ans;
    }
}