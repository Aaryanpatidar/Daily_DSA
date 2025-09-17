import java.util.*;

class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : arr){
            set.add(n);
        }
        int ans = 0,length;
        for(int n : set){
           if(!set.contains(n-1)){
                length=1;
                while(set.contains(n+length)){
                    length++;
                }
                ans = Math.max(ans,length);
            }
        }
        return ans;
    }
}