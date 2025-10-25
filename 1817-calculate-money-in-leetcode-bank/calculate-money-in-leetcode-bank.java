class Solution {
    public int totalMoney(int n) {
        int total = 0;
        
        int mon = 0;
        for(int i=1;i<=n;i++){
            if(i == 1 ||  (i-1) % 7 == 0){
                mon++;
            }
            total += mon + (i-1)%7;
        }

        return total;
    }
}