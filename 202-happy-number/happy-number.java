class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> h = new HashSet();
        
        while (true) {
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                sum += (d * d);
                n /= 10;
            }
            
            if (sum == 1) return true;
            if (h.contains(sum)) return false;
            h.add(sum);
            n = sum;
        }
    }
}