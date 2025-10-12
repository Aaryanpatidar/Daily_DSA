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

    public boolean equationsPossible(String[] arr) {
        int [] par = new int[26];
        int [] rank = new int[26];
        for(int i =0; i<26; i++){
            par[i] = i;
        }
        int n = arr.length;

        for(int i =0; i<n; i++){
            String s = arr[i];
            if(s.charAt(1) == '='){
                union(s.charAt(0)-'a', s.charAt(3)-'a',par, rank);
            }
        }

        for(int i =0; i<n; i++){
            String s = arr[i];
            if(s.charAt(1) == '!'){
                int a = find(par, s.charAt(0)-'a');
                int b = find(par, s.charAt(3)-'a');
                if(a==b){
                    return false;
                }
            }
        }

        return true;
    }
}