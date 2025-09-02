class Solution {
    public int reverse(int x) {
        return helper(x,0);
    }

    static int helper(int n , double rev){
        
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
            return 0;
        }
        
        if( n == 0){
            return (int) rev;
        }
        
        else{
            rev = (rev * 10) + (n % 10);

            return helper(n/10,rev);
        }
    }
}