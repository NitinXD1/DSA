class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        for(char ch : s.toCharArray()){
            hash1[ch-'a']++;
        }

        for(char ch : t.toCharArray()){
            hash2[ch-'a']++;
        }

        for(int i=0;i<26;i++){
            if(hash1[i] != hash2[i])return false;
        }

        return true;
    }
}