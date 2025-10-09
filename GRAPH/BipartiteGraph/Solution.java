import java.util.*;

class Solution {
    public boolean dfs(List<List<Integer>> ls, int u,boolean [] visited, int[] color, int c ){
        visited[u] = true;
        color[u] = c;
        int nextcolor = 1-c;
        
        for(int v : ls.get(u)){
            if(c == color[v]){
                return false;
            }
            if(!visited[v]){
                if(!dfs(ls,v,visited,color,nextcolor)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean bfs(List<List<Integer>> ls, int u,boolean [] visited, int[] color, int c ){
        visited[u] = true;
        color[u] = c;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        
        while(!q.isEmpty()){
            int u1 = q.remove();
            
            for(int v : ls.get(u1)){
                if(color[u1] == color[v]){
                    return false;
                }
                
                if(!visited[v]){
                    visited[v] = true;
                    q.add(v);
                    color[v] = 1-color[u1];
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int n, int[][] edges) {
        List<List<Integer>> ls = new ArrayList<>();
        boolean [] visited = new boolean[n];
        int [] color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i =0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        for(int i =0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        
        
        
        for(int i =0; i< n; i++){
            if(!visited[i]){
                // if(!dfs(ls,i,visited,color,0)){
                //     return false;
                // }
                if(!bfs(ls,i,visited,color,0)){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}