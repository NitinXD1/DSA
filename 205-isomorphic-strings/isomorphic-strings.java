class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hash = new HashMap<>();
        int n = s.length();

        int[] f = new int[128];

        for(int i=0;i<n;i++){
            char first = s.charAt(i);
            char second = t.charAt(i);
            if(hash.containsKey(first)){
                if(hash.get(first) != second){
                    return false;
                }
            }
            else{
                if(f[second] == 1)return false;
                f[second] = 1;
                hash.put(first,second);
            }
        }

        return true;
    }
}