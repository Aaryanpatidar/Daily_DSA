
class Solution {
    
    public void union_(int x, int z, int par[], int rank[]) {
        int a = find(par,x);
        int b = find(par,z);
        
        if(a==b){
            return;
        }
        
        if(rank[a]<rank[b]){
            par[a] = b;
        }else if(rank[a]>rank[b]){
            par[b] = a;
        }else{
            par[a] = b;
            rank[b]++;
        }
        
    }
    
    public int find(int []par, int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par,par[x]);
    }
 
    public Boolean isConnected(int x, int z, int par[], int rank[]) {
        int a = find(par,x);
        int b = find(par,z);
        if(a==b){
            return true;
        }
        return false;
    }
}