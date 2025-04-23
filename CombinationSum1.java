package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        generateCombinations(0, candidates, target, ds, ans);
        return ans;
    }

    public void generateCombinations(int index, int[] candidates, int target, List<Integer> ds, List<List<Integer>> ans){
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index] <= target){
            ds.add(candidates[index]);
            generateCombinations(index, candidates, target-candidates[index], ds, ans);
            ds.remove(ds.size()-1);
        }
        generateCombinations(index+1, candidates, target, ds, ans);
    }
}
