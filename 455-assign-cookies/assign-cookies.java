class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0;
        int j=0;

        int cnt=0;
        while(j < s.length){
            if(i < g.length && g[i] <= s[j]){
                i++;
                cnt++;
            }
            j++;
        }

        return cnt;
    }
}