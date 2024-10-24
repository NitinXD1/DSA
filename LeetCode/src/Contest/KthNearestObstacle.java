package Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Not SOLVED USE HEAPS
public class KthNearestObstacle {
    public static void main(String[] args) {
        int [][] arr = {{7,7},{9,-4}};
        System.out.println(Arrays.toString(resultsArray(arr,2)));
    }
    public static int[] resultsArray(int[][] queries, int k) {
        ArrayList<Integer> distances = new ArrayList<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length ; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            int dist = Math.abs(a)+Math.abs(b);
            //returns negative value if not present else +ve value
            int pos = Collections.binarySearch(distances,dist);
            if(pos<0){
                pos = -(pos+1);
            }
            distances.add(pos,dist);

            if(k>distances.size()){
                ans[i] = -1;
            }
            else{
                ans[i] = distances.get(k-1);
            }
        }
        return ans;
    }

}
