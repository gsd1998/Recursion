package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> parent = new ArrayList<>();
        int n = nums.length;
        printSubsets(nums, 0, list, n, parent);
        return parent;
    }

    public void printSubsets(int[] nums, int index, ArrayList<Integer> list, int n, List<List<Integer>> parent) {
        if(index == n){
            parent.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        printSubsets(nums, index+1, list, n, parent);
        list.remove(list.size() - 1);
        printSubsets(nums, index+1, list, n, parent);
    }
}
