class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> st = new HashSet<>();
        st.add(n);

        while(n > 1){
            int sum = 0;
            
            String num = String.valueOf(n);
            
            for(char ch : num.toCharArray()){
                sum += Math.pow(ch-'0',2);
            }

            if(st.contains(sum))return false;
            
            st.add(sum);
            n = sum;
        }

        return n == 1;
    }
}