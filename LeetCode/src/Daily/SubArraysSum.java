package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubArraysSum {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};

        System.out.println(rangeSum(arr,4,3,4));

    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int prefix = 0;
            for (int j = i; j < n; j++) {
                prefix += nums[j];
                arr.add(prefix);
            }
        }

        Collections.sort(arr);

        System.out.println(arr);

        int Sum = 0;

        for (int i = left-1; i < right ; i++) {
            Sum += arr.get(i);
        }

        return Sum;

    }
}
