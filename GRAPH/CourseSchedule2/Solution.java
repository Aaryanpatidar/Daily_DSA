import java.util.*;

class Solution {
    boolean isCycle = false;

    public void dfs(List<List<Integer>> ls,int u, boolean[] visited, boolean[] currec,Stack<Integer> stk ){
        visited[u]= true;
        currec[u]= true;

        for(int v : ls.get(u)){
            if(currec[v]){
                isCycle = true;
                return;
            }
            if(!visited[v]){
                dfs(ls,v,visited,currec,stk);
            }
        }
        stk.push(u);
        currec[u] = false;
    }

    public int[] findOrder(int n, int[][] pre) {

        List<List<Integer>> ls = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] currec = new boolean[n];
        Stack<Integer> stk = new Stack<>();
        int [] result = new int[n];

        for(int i =0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        for(int i =0; i<pre.length; i++){
            int a = pre[i][0];
            int b = pre[i][1];
            ls.get(b).add(a);
        }

        for(int i = 0; i<n ; i++){
            if(!visited[i]){
                dfs(ls,i,visited,currec,stk);
            }
        }

        if(isCycle){
            return new int[]{};
        }

        for(int i =0; i<n; i++){
            result[i] = stk.pop();
        }

        return result;

    }
}