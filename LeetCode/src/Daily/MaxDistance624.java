package Daily;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance624 {
    public static void main(String[] args) {

    }

    public int maxDistance(List<List<Integer>> arrays) {

        int minElement = arrays.get(0).get(0);
        int maxElement = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            // Update maxDistance with the maximum of the current calculated distances
            maxDistance = Math.max(maxDistance, Math.max(maxElement - currentMin, currentMax - minElement));

            // Update global min and max for future iterations
            minElement = Math.min(minElement, currentMin);
            maxElement = Math.max(maxElement, currentMax);
        }

        return maxDistance;
    }
}
