import java.util.*;

class Solution {
    List<String> ans;

    public void rec(int i, String digits, String[] arr, StringBuilder sb){

        if(i == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String s = arr[digits.charAt(i) - '0'];
        for(int ind = 0; ind < s.length(); ind++){
            sb.append(s.charAt(ind));
            rec(i+1, digits, arr, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {

        int n = digits.length();
        ans = new ArrayList<>();

        if(n==0){
            return ans;
        }
       
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder("");
        rec(0,digits,arr,sb);

        return ans;
    }
}