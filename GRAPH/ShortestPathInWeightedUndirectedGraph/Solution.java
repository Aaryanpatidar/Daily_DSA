import java.util.*;

class Solution {
    public List<Integer> shortestPath(int n, int m, int e[][]) {
        List<List<int []>> ls = new ArrayList<>();
        long [] dist = new long[n+1];
        int [] from = new int[n+1];
        
        for(int i =0; i<=n; i++){
            ls.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
            from[i] = -1;
        }
        
        for(int i =0; i<m; i++){
            int u = e[i][0], v = e[i][1], w = e[i][2];
            ls.get(u).add(new int[]{v,w});
            ls.get(v).add(new int[]{u,w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        pq.add(new int[]{0,1});
        dist[1] = 0;
        from[1] = 1;
        
        while(!pq.isEmpty()){
            int [] a = pq.remove();
            int u = a[1], d = a[0];
            if(d>dist[u])continue;
            
            for(int [] x: ls.get(u)){
                int v = x[0], w = x[1];
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    from[v] = u;
                    pq.add(new int[]{(int)dist[v],v});
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if(dist[n]==Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        
        int i = n;
        while(i!=1){
            ans.add(i);
            i = from[i];
        }
        ans.add(1);
        ans.add((int)dist[n]);
        Collections.reverse(ans);
        return ans;
    }
}