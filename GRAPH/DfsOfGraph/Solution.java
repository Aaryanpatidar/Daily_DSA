import java.util.*;

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj,int u, boolean [] visited, ArrayList<Integer> ans){
        visited[u] =true;
        ans.add(u);
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj,v,visited,ans);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        boolean [] visited = new boolean [n];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i =0; i< n; i++){
            if(!visited[i]){
                dfs(adj,i,visited,ans);
            }
        }
        
        return ans;
    }
}