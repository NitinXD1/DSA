class Solution {
    public int maximum69Number (int num) {
        int ans = 0;
        int limit = 1;

        for(char ch : String.valueOf(num).toCharArray()){
            if(ch == '6' && limit == 1){
                ans = (ans * 10) + 9;
                limit--;
                continue;
            }
            ans = (ans * 10) + (ch - '0');
        }

        return ans;
    }
}