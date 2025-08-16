class Solution {
    public int maximum69Number (int num) {
        StringBuilder ans = new StringBuilder();
        int limit = 1;

        for(char ch : String.valueOf(num).toCharArray()){
            if(ch == '6' && limit == 1){
                ans.append('9');
                limit--;
                continue;
            }
            ans.append(ch);
        }

        return Integer.parseInt(ans.toString());
    }
}