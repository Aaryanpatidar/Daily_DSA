import java.util.*;

class Pair {
    int first;
    double second;

    Pair(int first, double second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int carFleet(int tar, int[] pos, int[] s) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.first-a.first);
        int n = pos.length;
        
        for(int i =0; i<n ; i++){
            double time = (double)(tar-pos[i])/s[i];
            Pair p = new Pair(pos[i],time);
            pq.add(p);
        }

        Stack<Double> stk = new Stack<>();
        int ans =0;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            while(!stk.isEmpty() && stk.peek()<p1.second){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans++;
            }
            stk.push(p1.second);
        }

        return ans;


        // int ans =0;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // int n = pos.length;
        // for(int i =0 ; i<n; i++){
        //     hm.put(pos[i],s[i]);
        // }
        // Arrays.sort(pos);
        // double arr[] = new double[n];
        // double rm = arr[n-1];
        // for(int i =n-1 ;i>=0; i--){
        //     arr[i] = (double)(tar-pos[i])/hm.get(pos[i]);
        //      if(arr[i]>rm){
        //         ans++;
        //         rm=arr[i];
        //     }
        // }
        
        // return ans;
    }
}