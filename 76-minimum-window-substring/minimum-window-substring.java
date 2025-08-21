class Solution {
    public String minWindow(String s, String t) {

        int left = 0;
        int right = 0; int n = s.length();

        HashMap<Character,Integer> hash = new HashMap<>();
        for(char ch : t.toCharArray())hash.put(ch,hash.getOrDefault(ch,0)+1);

        int cnt = 0;
        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;

        while(right < n){
            char ch = s.charAt(right);
            
            if(hash.containsKey(ch) && hash.get(ch) > 0){
                cnt++;
            }

            hash.put(ch,hash.getOrDefault(ch,0) - 1);
            while(cnt == t.length()){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    sIndex = left;
                }
                hash.put(s.charAt(left),hash.get(s.charAt(left)) + 1);
                if(hash.get(s.charAt(left)) > 0){
                    cnt--;
                }
                left++;
            }
            right++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex,sIndex + minLen);
    }
}