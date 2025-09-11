class Solution {
    public String sortVowels(String s) {
        List<Character> ls = new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                ls.add(ch);
            }
        }

        Collections.sort(ls);

        StringBuilder ans = new StringBuilder();
        int index = 0;

        for(char ch:s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                ans.append(ls.get(index));
                index++;
            }
            else ans.append(ch);
        }

        return ans.toString();
    }
}