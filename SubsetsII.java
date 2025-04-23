package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {2,3};
        System.out.println(subsetsWithDup(nums));//[[], [2], [2, 3], [3]]
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> parent = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        printSubsets(nums, 0, list, n, parent);
        return parent;
    }

    public static void printSubsets(int[] nums, int index, ArrayList<Integer> list, int n, List<List<Integer>> parent) {
        parent.add(new ArrayList<>(list));
        for(int i = index; i <= nums.length-1; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            printSubsets(nums, i+1, list, n, parent);
            list.remove(list.size() - 1);
        }
    }
}
