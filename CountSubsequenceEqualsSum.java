package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequenceEqualsSum {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(subsets(nums));//[[1, 1]]
    }

    public static int subsets(int[] nums) {
        int n = nums.length;
        int sum = 2;
        int s = 0;
        return printSubsets(nums, 0, n, sum, s);//2
    }

    public static int printSubsets(int[] nums, int index, int n, int sum, int s) {
        if(index == n) {
            if (sum == s) {
                return 1;
            }
            return 0;
        }
        s = s + nums[index];
        int l = printSubsets(nums, index+1, n, sum, s);
        s = s - nums[index];
        int r = printSubsets(nums, index+1, n, sum, s);
        return l+r;
    }
}
