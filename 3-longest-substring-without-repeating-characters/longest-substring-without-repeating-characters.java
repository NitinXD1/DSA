class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length(); 

        HashMap<Character,Integer> hash = new HashMap<>();
        int ans = 0;

        while(right < n){
            hash.put(s.charAt(right),hash.getOrDefault(s.charAt(right),0) + 1);

            while(hash.get(s.charAt(right)) > 1){
                hash.put(s.charAt(left),hash.get(s.charAt(left))-1);
                left++;
            }

            ans = Math.max(ans,right - left + 1);
            right++;
        }

        return ans;
    }
}