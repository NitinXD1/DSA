class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int cnt = 0;
        for(String str : words){
            boolean flag = false;
            for(char ch : brokenLetters.toCharArray()){
                if(str.contains(ch+"")){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                cnt++;
            }
        }
        return cnt;
    }
}