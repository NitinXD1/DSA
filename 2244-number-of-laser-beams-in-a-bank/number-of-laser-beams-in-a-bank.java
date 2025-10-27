class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int[] suff = new int[n];

        for(int i=n-1;i>=0;i--){
            int count = find(bank[i]);
            if(count > 0)suff[i] = count; 
        }

        int i=0; 
        while(i < n && suff[i] == 0){
            i++;
        }

        int j=i+1;
        int ans = 0;

        while(j < n){
            if(suff[j] != 0){
                ans += suff[i] * suff[j];
                i = j;
            }
            j++;
        }

        return ans;
    }

    public int find(String s){
        int cnt = 0;
        for(char ch:s.toCharArray()){
            if(ch == '1')cnt++;
        }
        return cnt;
    }
}