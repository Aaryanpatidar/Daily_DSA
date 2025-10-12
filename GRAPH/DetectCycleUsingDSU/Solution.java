import java.util.*;

class Solution {
    
    public int find(int par[], int x){
        if(par[x]==x){
            return x;
        }
        return par[x] = find(par,par[x]);
    }
    
    public boolean union(int par[], int rank[] , int x, int z){
        int a = find(par,x);
        int b = find(par,z);
        if(a == b)return false;
        
        if(rank[a]<rank[b]){
            par[a]=b;
        }else if(rank[a]>rank[b]){
            par[b]=a;
        }else{
            par[a]=b;
            rank[a]++;
        }
        return true;
    }
    
    public int detectCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        
        int par[] = new int[n];
        int rank[] = new int[n];
        
        for(int i =0; i<n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int u =0; u<adj.size(); u++){
            for(int v : adj.get(u)){
                if(u<v && (!union(par,rank,u,v))){
                    return 1;
                }
            }
        }
        
        return 0;
    }
}