import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length(),i=0,j=0,ans=0;
        int st =0;
        for( i =0; i<n; i++) {
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                ans = Math.max(ans,set.size());
            }else{
                while(set.contains(c)){
                    set.remove(s.charAt(st));
                    st++;
                }
                set.add(c);
            }
        }
        return ans;

        // while(j<n){
        //     while(j<n && !set.contains(s.charAt(j))){
        //         set.add(s.charAt(j));
        //         j++;
        //     }
        //     ans= Math.max(ans,j-i);
        //     if(j==n){break;}
        //     while(s.charAt(i) != s.charAt(j)){
        //         set.remove(s.charAt(i));
        //         i++;
        //     }
        //     set.remove(s.charAt(i));
        //     i++;
        // }
       // return ans;
    }
}