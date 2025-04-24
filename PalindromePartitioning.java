package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        List<String> list = new ArrayList<>();
        generateSubsequence(0,n,s,ans,list);
        return ans;
    }

    public void generateSubsequence(int index, int n, String s, List<List<String>> ans, List<String> list){
        if(index == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i <= n-1; i++){
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index,i+1));
                generateSubsequence(i+1,n,s,ans,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right){
        if(s.length() == 0){
            return false;
        }
        if(s.length() == 1){
            return true;
        }
        while(left < right){
            if(s.charAt(left)==(s.charAt(right))){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
