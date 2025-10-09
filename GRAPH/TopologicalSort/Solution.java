import java.util.*;

class Solution {
    public static void dfs(boolean [] visited,int u, Stack<Integer> demo,List<List<Integer>>ls ){
        visited[u] = true;
        
        for(int v : ls.get(u)){
            if(!visited[v]){
                dfs(visited,v, demo, ls);
            }
        }
        
        demo.push(u);
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        List<List<Integer>>ls = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> demo = new Stack<>();
        
        for(int i =0; i<V; i++){
            ls.add(new ArrayList<>());
        }
        
        for(int i =0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            ls.get(a).add(b);
        }
        
        boolean [] visited = new boolean [V];
        
        for(int i =0; i<V; i++){
            if(!visited[i]){
                dfs(visited, i,demo, ls);
            }
        }
        
        while(!demo.isEmpty()){
            ans.add(demo.pop());
        }
        return ans;
         
        // int [] indeg = new int[V];
        // Queue<Integer> q = new LinkedList<>();
        // ArrayList<Integer> ans = new ArrayList<>();
        // List<List<Integer>> ls = new ArrayList<>();
        // for(int i = 0; i<V; i++){
        //     ls.add(new ArrayList<>());
        // }
        
        // for(int i = 0; i< edges.length; i++){
        //     int a = edges[i][0];
        //     int b = edges[i][1];
        //     ls.get(a).add(b);
        //     indeg[b]++;
        // }
        
        // for(int i = 0; i<V; i++){
        //     if(indeg[i]==0){
        //         q.add(i);
        //         ans.add(i);
        //     }
        // }
        
        // while(!q.isEmpty()){
        //     int a = q.remove();
        //     for(int x : ls.get(a)){
        //         indeg[x]--;
        //         if(indeg[x]==0){
        //             q.add(x);
        //             ans.add(x);
        //         }
        //     }
        // }
        
        // return ans;
        
    }
}