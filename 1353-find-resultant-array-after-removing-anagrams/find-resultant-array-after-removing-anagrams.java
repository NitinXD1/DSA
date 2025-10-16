class Solution {
    public List<String> removeAnagrams(String[] words) {
        HashMap<Character,Integer> prev = new HashMap<>();
        List<String> ans = new ArrayList<>();

        ans.add(words[0]);
        for(char ch:words[0].toCharArray()){
            prev.put(ch,prev.getOrDefault(ch,0)+1);
        }

        for(int i=1;i<words.length;i++){
            HashMap<Character,Integer> curr = new HashMap<>();
            for(char ch:words[i].toCharArray()){
                curr.put(ch,curr.getOrDefault(ch,0)+1);
            }

            if(!curr.equals(prev)){
                ans.add(words[i]);
                prev = curr;
            }
        }

        return ans;
    }
}