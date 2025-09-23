class Solution {
    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        int n = Math.max(first.length,second.length);

        for(int i=0;i<n;i++){
            int a = i < first.length ? Integer.parseInt(first[i]) : 0;
            int b = i < second.length ? Integer.parseInt(second[i]) : 0;

            if(a > b)return 1;
            if(b > a)return -1;
        }

        return 0;
    }
}