package Daily;

public class XORsubArrayQueries {
    public static void main(String[] args) {

    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int [] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for(int i = 1; i < arr.length;i++){
            preSum[i] = preSum[i-1] ^ arr[i];
        }
        int[] ans = new int [queries.length];
        for(int i = 0; i < queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0){
                ans[i] = preSum[end];
            }
            else{
                ans[i] = preSum[start - 1] ^ preSum[end];
            }
        }
        return ans;
    }
}
