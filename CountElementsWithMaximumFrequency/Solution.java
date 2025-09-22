import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer, Integer>map = new HashMap<>();
        int maxi =-1;

        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
            maxi = Math.max(maxi,map.get(i));
        }
        int ans =0;
        for(int i : map.keySet()){
            if(map.get(i)==maxi){
                ans+=maxi;
            }
        }
        return ans;
    }
}