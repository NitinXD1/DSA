package Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class sneakyNumber {
    public static void main(String[] args) {
        int [] nums = {7,1,5,4,3,4,6,0,9,5,8,2};
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }

    public static int[] getSneakyNumbers(int[] nums) {
//        HashMap<Integer,Integer> mpp = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length ; i++) {
//            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
//            if(mpp.get(nums[i]) == 2) list.add(nums[i]);
//        }
//        return list.stream().mapToInt(i -> i).toArray();
        int n = nums.length;
        int [] hash = new int[n];
        for (int i = 0; i < nums.length ; i++) {
            hash[nums[i]]++;
        }
        int [] ans = {-1,-1};
        for (int i = 0; i < hash.length ; i++) {
            if(hash[i] == 2 && ans[0] == -1){
                ans[0] = i;
            } else if (hash[i] == 2) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
