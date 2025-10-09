import java.util.*;

class Solution {
    public boolean dfs(boolean [] visited,int u, boolean [] currec,List<List<Integer>> ls){
        visited[u] = true;
        currec[u] = true;
        
        for(int v : ls.get(u)){
            if(currec[v]){
                return false;
            }
            if(!visited[v]){
                if(!dfs(visited,v,currec,ls)){
                    return false;
                }
            }
        }
        currec[u] = false;
        return true;
    }

    public boolean canFinish(int n, int[][] arr) {

        //DFS

        List<List<Integer>> ls = new ArrayList<>();
        for(int i =0; i<n; i++){
            ls.add(new ArrayList<>());
        }

        for(int i =0; i<arr.length; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            ls.get(b).add(a);
        }

        boolean [] visited = new boolean[n];
        boolean [] currec = new boolean[n];

        for(int i = 0; i<n; i++){
            if(!visited[i]){
               if(!dfs(visited,i,currec,ls)){
                    return false;
               }
            }
        }

        return true;


        // Using Kahn's Algorithm
        // Map<Integer,List<Integer>> mpp = new HashMap<>();
        // int[] inDegree = new int[n];

        // for(int i =0; i<n; i++){
        //     mpp.put(i,new ArrayList<>());
        // }

        // for(int i =0; i<arr.length; i++){
        //     int a = arr[i][0];
        //     int b = arr[i][1];
        //     mpp.get(b).add(a);
        //     inDegree[a]++;
        // }

        // int count = 0;
        // Queue<Integer> q = new LinkedList<>();
        // for(int i =0; i<n; i++){
        //     if(inDegree[i] == 0){
        //         q.add(i);
        //         count++;
        //     }
        // }

        // while(!q.isEmpty()){
        //     int a = q.remove();
        //     for(int s : mpp.get(a)){
        //         inDegree[s]--;
        //         if(inDegree[s] == 0){
        //             q.add(s);
        //             count++;
        //         }
        //     }
        // }

        // if(count == n){
        //     return true;
        // }

        // return false;

    }
}