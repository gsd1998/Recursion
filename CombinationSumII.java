package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(0, candidates, target, ds, ans);
        return ans;
    }

    public void generateCombinations(int index, int[] candidates, int target,
                                     List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index ; i <= candidates.length-1; i++){
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target){
                break;
            }
            ds.add(candidates[i]);
            generateCombinations(i+1, candidates, target-candidates[i], ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}
