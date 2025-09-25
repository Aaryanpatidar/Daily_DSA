import java.util.*;

class Pair1 {
    Long dis;
    int[] point;
    Pair1(Long dis, int[] point){
        this.dis = dis;
        this.point = point;
    }
}

public class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair1> pq = new PriorityQueue<Pair1>((a,b) -> (int)(b.dis-a.dis));
        int [][] ans = new int[k][2];

        for(int i =0 ; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            Long dis = (long)(x*x) + (long)(y*y);
            Pair1 p = new Pair1(dis,points[i]);
            pq.add(p);
            if(pq.size()>k){
                pq.remove();
            }
        }

        int ind = 0;
        while(!pq.isEmpty()){
            ans[ind] = pq.remove().point;
            ind++;
        }

        return ans;
    }
}