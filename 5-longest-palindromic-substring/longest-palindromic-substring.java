class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        String ans = "";
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(isPalindrome(s,j,i)){
                    if(i-j+1 > ans.length()){
                        ans = s.substring(j,i+1);
                    }
                }
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s,int st,int en){
        
        while(st < en){
            if(s.charAt(st) != s.charAt(en))return false;
            st++;
            en--;
        }

        return true;
    }
}