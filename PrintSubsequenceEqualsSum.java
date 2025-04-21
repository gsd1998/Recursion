package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequenceEqualsSum {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(subsets(nums));//[[1, 1], [2]]
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> parent = new ArrayList<>();
        int n = nums.length;
        int sum = 2;
        int s = 0;
        printSubsets(nums, 0, list, n, parent, sum, s);
        return parent;
    }

    public static void printSubsets(int[] nums, int index, ArrayList<Integer> list, int n, List<List<Integer>> parent,int sum, int s) {
        if(index == n){
            if(sum == s) {
                parent.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[index]);
        s = s + nums[index];
        printSubsets(nums, index+1, list, n, parent, sum, s);
        list.remove(list.size() - 1);
        s = s - nums[index];
        printSubsets(nums, index+1, list, n, parent, sum, s);
    }
}
