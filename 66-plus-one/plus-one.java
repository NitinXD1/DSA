class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length; 
            
        for(int i=n-1;i>=0;i--){
            if(digits[i] == 9 && carry == 1){
                carry = 1;
                digits[i] = 0;
            }
            else{
                digits[i] += carry;
                carry = 0;
            }    
        }

        if(carry == 1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }

        return digits;
    }
}