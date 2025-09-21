import java.util.*;

class Solution {
    public void fun(List<String> ans, int left, int right, StringBuilder sb){

        if(left==0 && right ==0){
            ans.add(sb.toString());
            return;
        }
        if(left>0){
            sb.append('(');
            fun(ans,left-1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right>left){
            sb.append(')');
            fun(ans,left,right-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }


    }
    public List<String> generateParenthesis(int n) {
        int left=n,right=n;
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        fun(ans,left,right,sb);
        return ans;
    }
}