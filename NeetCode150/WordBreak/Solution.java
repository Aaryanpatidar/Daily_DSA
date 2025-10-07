import java.util.*;

class Solution {
    Set<String> set;
    Boolean[] check;

    public boolean rec(String s, int i, int n){
        if(i == n){
            return true;
        }
        if(check[i] != null){
            return check[i];
        }
        for(int j = i+1; j<=Math.min(n,(i+20)); j++){
            String st = s.substring(i,j);
            if(set.contains(st) && rec(s, j, n)){
                return check[i] = true;
            }
        }
        return check[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n  = s.length();
        set = new HashSet<>(wordDict);
        check = new Boolean[n];

        return rec(s,0,n);
    }
}