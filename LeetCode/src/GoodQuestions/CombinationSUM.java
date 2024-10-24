package GoodQuestions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSUM {
    public static void main(String[] args) {
        int [] arr = {2,3,5};
        System.out.println(combinationSum(arr,8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        return list(res,set,candidates,target,0);
    }

    static List<List<Integer>> list(List<List<Integer>> res,List<Integer> cuurentSet,int[] candidates,int target,int index){

        if(target == 0){
            List<Integer> set = new ArrayList<>(cuurentSet);
            res.add(set);
            return res;
        }

        if(target < 0){
            return new ArrayList<>();
        }

        for (int i = index; i < candidates.length ; i++) {

            if(target - candidates[i] >= 0){
                cuurentSet.add(candidates[i]);
                list(res,cuurentSet,candidates,target-candidates[i],i);
                cuurentSet.remove(cuurentSet.size()-1);
            }

        }

        return res;
    }

}
