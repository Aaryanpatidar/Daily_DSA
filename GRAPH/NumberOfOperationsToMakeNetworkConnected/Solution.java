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

        if(a==b)return;

        if(rank[a]<rank[b]){
            par[a] = b;
        }else if(rank[a]>rank[b]){
            par[b] = a;
        }else{
            par[a] = b;
            rank[b]++;
        }
    }

    public int makeConnected(int n, int[][] arr) {
        int edges = arr.length;
        int [] par = new int[n];
        int [] rank = new int[n];
        for(int i =0; i< n; i++){
            par[i] = i;
        }

        if(edges<(n-1))return -1;

        for(int u = 0; u<arr.length; u++){
            int a = arr[u][0];
            int b = arr[u][1];
            union(a,b,par,rank);
        }
        int count =0;
        for(int i =0; i<n ; i++){
            if(par[i]==i){
                count++;
            }
        }
        return count-1;
    }
}