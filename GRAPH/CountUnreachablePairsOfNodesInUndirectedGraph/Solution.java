import java.util.*;

class Solution {
    public int find(int []par, int x){
        if(par[x]==x){
            return x;
        }
        return par[x] = find(par, par[x]);
    }

    public void union(int x, int z, int []par, int []rank){
        int a = find(par, x);
        int b = find(par, z);

        if(a == b)return;

        if(rank[a]<rank[b]){
            par[a] = b;
        }else if(rank[a]>rank[b]){
            par[b] = a;
        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    public long countPairs(int n, int[][] arr) {
        int [] par = new int[n];
        int [] rank = new int[n];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<n; i++){
            par[i] = i;
            rank[i] =1;
        }
        
        for(int i =0; i<arr.length; i++){
            union(arr[i][0],arr[i][1],par,rank);
        }
        
        for(int i =0; i<n; i++){
            int a = find(par,i);
            map.put(a,map.getOrDefault(a,0)+1);
        }

        long ans =0;
        long remain = n;
        for(int i : map.keySet()){
            int a = map.get(i);
            remain -= a;
            ans += remain*a;
        }
        return ans;
    }
}