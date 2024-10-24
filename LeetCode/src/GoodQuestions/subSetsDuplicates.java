package GoodQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSetsDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        System.out.println(subsetsWithDup(arr));
    }

    static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the array to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        // Start the recursive process
        list(res, set, nums, 0);
        return res;
    }

    static void list(List<List<Integer>> res, List<Integer> currentSet, int[] nums, int index) {
        // Add the current subset to the result
        res.add(new ArrayList<>(currentSet));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            // Include nums[i] in the current subset
            currentSet.add(nums[i]);
            // Recur with the next index
            list(res, currentSet, nums, i + 1);
            // Backtrack and remove the last element
            currentSet.remove(currentSet.size() - 1);
        }
    }
}
