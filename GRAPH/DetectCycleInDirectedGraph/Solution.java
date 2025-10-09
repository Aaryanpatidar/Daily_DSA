import java.util.*;

class Solution {
    
    public boolean dfs(List<List<Integer>> ls,int u, boolean [] visited, boolean [] currec){
        visited[u] = true;
        currec[u] = true;
        
        for(int v : ls.get(u)){
            if(currec[v]){
                return true;
            }
            if(!visited[v] && dfs(ls,v,visited,currec)){
                return true;
            }
        }
        
        currec[u] = false;
        
        return false;
    }
    
    public boolean isCyclic(int n, int[][] edges) {
       List<List<Integer>> ls = new ArrayList<>();
       //boolean [] visited = new boolean[n];
       //boolean [] currec = new boolean[n];
       int [] indeg = new int[n];
       
       for(int i =0; i<n; i++){
           ls.add(new ArrayList<>());
       }
       
       for(int i =0; i<edges.length; i++){
           int a = edges[i][0];
           int b = edges[i][1];
           ls.get(a).add(b);
           indeg[b]++;
       }
       
       
       Queue<Integer> q = new LinkedList<>();
       int count =0;
       
       for(int i =0; i<n; i++){
           if(indeg[i]==0){
               q.add(i);
               count++;
           }
       }
       
       while(!q.isEmpty()){
           int u = q.remove();
           for(int v : ls.get(u)){
               indeg[v]--;
               if(indeg[v]==0){
                   q.add(v);
                   count++;
               }
           }
       }
       
       if(count != n){
           return true;
       }
       
       return false;
       
    //   for(int i =0; i<n; i++){
    //       if(!visited[i] && dfs(ls,i,visited,currec)){
    //           return true;
    //       }
    //   }
       
    //   return false;
    }
}