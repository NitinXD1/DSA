class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));

        int n = intervals.length;
        int i=1; int cnt = 0;
        int end = intervals[0][1];

        while(i<n){
            while(i<n && intervals[i][0] < end){
                i++;
                cnt++;
            }

            if(i == n)break;

            end = intervals[i][1];
            i++;
        }

        return cnt;
    }
}