import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        List<Integer>temp = new ArrayList<>();
        temp.add(arr.get(0).get(0));
        for(int i =1; i<n;i++){
            List<Integer> cur = new ArrayList<>();
            for(int j =0; j<temp.size(); j++){
                int ind = temp.get(j);
                int a = arr.get(i).get(j);
                int b = arr.get(i).get(j+1);
                if (j == 0) {
                    cur.add(ind + a);
                } else {
                    cur.set(j, Math.min(cur.get(j), ind + a));
                }
                cur.add(ind+b);
            }
            temp = cur;
        }
        int ans = Integer.MAX_VALUE;
        for(int i =0; i<temp.size(); i++){
            ans = Math.min(ans,temp.get(i));
        }
        return ans;
    }
}