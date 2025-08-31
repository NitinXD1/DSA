class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalG = 0;
        int totalC = 0;
        int n = gas.length;

        for(int i=0;i<n;i++){
            totalG += gas[i];
            totalC += cost[i];
        }

        if(totalG < totalC)return -1;

        int ans = 0;
        int bal = 0;

        for(int i=0;i<n;i++){
            bal = (bal + gas[i]) - cost[i];
            if(bal < 0){
                bal = 0;
                ans = i+1;
            } 
        }

        return ans;
    }
}