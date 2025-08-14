class Solution {
    public String largestGoodInteger(String num) {
        String ans = ""; int n = num.length();
        char pre = num.charAt(0);
        int freq = 1;

        for(int i=1;i<n;i++){
            char ch = num.charAt(i);
            if(ch == pre){
                freq++;
            }
            else{
                pre = ch;
                freq = 1;
            }

            if(freq == 3){
                if(ans.length() == 0 || Integer.parseInt(ans) < Integer.parseInt(num.substring(i-2,i+1))){
                    ans = num.substring(i-2,i+1);
                }
            }
        }

        return ans;
    }
}