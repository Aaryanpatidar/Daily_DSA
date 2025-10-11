import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;

        Map<Integer,Long> map = new HashMap<>();
        for(int i =0; i<n;i++){
            map.put(power[i], map.getOrDefault(power[i],0l)+power[i]);
        }   

        List<Integer> ls = new ArrayList<>(map.keySet());
        Collections.sort(ls);

        int n1 = ls.size();
        long []dp = new long [n1];
        dp[0] = map.get(ls.get(0));

        for(int i = 1; i<n1; i++){
            long take = map.get(ls.get(i));
            int j = i-1;

            while(j>=0 && (ls.get(i)-ls.get(j))<=2){
                j--;
            }
            if(j>=0){
                take = take + dp[j];
            }
            long notTake = dp[i-1];

            dp[i] = Math.max(notTake, take);
        }

        return dp[n1-1];
    }
}