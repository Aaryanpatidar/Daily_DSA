import java.util.*;

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        int n = adj.size();
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()){
            int u = q.remove();
            ans.add(u);
            for(int v : adj.get(u)){
                if(!visited[v]){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        
        return ans;
    }
}