package GoodQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
     int[] arr = {3,3,0,3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        return ansWithDuplicates(res,set,nums,used);
    }

    static List<List<Integer>> ans(List<List<Integer>> res,List<Integer> set,int[] arr){
        if(set.size() == arr.length){
            List<Integer> part = new ArrayList<>(set);
            res.add(part);
            return res;
        }

        for (int i = 0; i < arr.length ; i++) {
            if(set.contains(arr[i])){
                continue;
            }
            set.add(arr[i]);
            ans(res,set,arr);
            set.remove(set.size()-1);
        }

        return res;
    }

    static List<List<Integer>> ansWithDuplicates(List<List<Integer>> res,List<Integer> set,int[] arr,boolean[] used){
        if(set.size() == arr.length){
            List<Integer> part = new ArrayList<>(set);
            res.add(part);
            return res;
        }

        for (int i = 0; i < arr.length ; i++) {
            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
                continue;
            }

            // Include this element in the permutation
            set.add(arr[i]);
            used[i] = true; // Mark it as used

            // Recurse to generate further permutations
            ansWithDuplicates(res, set, arr, used);

            // Backtrack: Remove the last element and mark it as unused
            set.remove(set.size() - 1);
            used[i] = false;
        }

        return res;
    }
}
