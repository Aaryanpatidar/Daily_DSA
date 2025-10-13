import java.util.*;

class Solution {
    public int[] dijkstra(int n, int[][] e, int src) {
        
        List<List<int[]>> ls = new ArrayList<>();
        int [] dist = new int[n];
        for(int i =0; i<n; i++){
            ls.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i =0; i< e.length;i++){
            int u = e[i][0], v= e[i][1], w= e[i][2];
            ls.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        pq.add(new int[]{0,src});
        dist[src]=0;
        
        while(!pq.isEmpty()){
            int [] a = pq.remove();
            int d = a[0], u = a[1];
            
            if(d > dist[u])continue;
            
            for(int [] ar : ls.get(u)){
                int v = ar[0], w = ar[1];
                if(dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        return dist;
    }
}