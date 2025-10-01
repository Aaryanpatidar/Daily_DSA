import java.util.*;

class Solution {

    List<List<String>>ans = new ArrayList<>();
    List<String>temp = new ArrayList<>();

    public void rec(int i, int j, String s){
       if(i==j && i==s.length()){
            ans.add(new ArrayList<>(temp));
       }
       if(j == s.length()){
            return;
       }
       if(isp(i,j,s)){
            temp.add(s.substring(i,j+1));
            rec(j+1,j+1,s);
            temp.remove(temp.size()-1);
       }
       rec(i,j+1,s);
    }

    public boolean isp(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        rec(0,0,s);
        return ans;
    }
}