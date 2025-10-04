class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n<2)return 0;
        int a = cost[0];
        int b = cost[1], c;
        for(int i = 2; i<n; i++){
            c = Math.min(a,b) + cost[i];
            a = b;
            b = c;
        }
        return a>b ? b : a ;
    }
}