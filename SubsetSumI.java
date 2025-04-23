package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumI {

    public static void main(String[] args) {
        int[] nums = {2,3};
        System.out.println(subsetSum(nums));//[5, 2, 3, 0]
    }

    public static ArrayList<Integer> subsetSum(int[] nums){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int sum = 0;
        generateSubsetSums(nums, 0, n, ans, sum);
        return ans;
    }

    private static void generateSubsetSums(int[] nums, int index, int n, ArrayList<Integer> ans, int sum) {
        if(index == n){
            ans.add(sum);
            return;
        }
        sum = sum + nums[index];
        generateSubsetSums(nums, index+1, n, ans, sum);
        sum = sum - nums[index];
        generateSubsetSums(nums, index+1, n, ans, sum);
    }
}
