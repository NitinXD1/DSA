class Solution {
    public long flowerGame(int n, int m) {
        long cnt = 0;
        
        long oddN = 0;
        long evenN = 0;

        for(int i=1;i<=n;i++){
            if(i % 2 == 1)oddN++;
            else evenN++;
        }

        long evenM = 0;
        long oddM = 0;

        for(int i=1;i<=m;i++){
            if(i % 2 == 0)evenM++;
            else oddM++;
        }

        return (long) evenM * oddN + evenN * oddM;
    }
}