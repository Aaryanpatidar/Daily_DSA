class Solution {

    int find(int par [], int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par,par[x]);
    }

    void union(int x, int z, int []par, int []rank){
        int a = find(par,x);
        int b = find(par,z);
        if(a==b)return;

        if(rank[a]<rank[b]){
            par[a]=b;
        }else if(rank[a]>rank[b]){
            par[b]=a;
        }else{
            par[a]=b;
            rank[b]++;
        }
    }

    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int par[] = new int [n];
        int [] rank = new int[n];
        for(int i=0; i<n; i++){
            par[i] = i;
            rank[i] =0;
        }

        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                if(arr[i][j]==1 && i<j){
                    union(i,j,par,rank);
                }
            }
        }

        int ans =0;
        for(int i =0; i<n; i++){
            if(par[i]==i)ans++;
        }

        return ans;
    }
}