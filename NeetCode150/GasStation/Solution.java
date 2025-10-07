class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum =0, cur = 0, ind =0, n = gas.length;
        for(int i = 0; i<=n-1; i++){
            sum+=(gas[i]-cost[i]);
            cur+=(gas[i]-cost[i]);
            if(cur<0){
                cur = 0;
                ind = i+1;
            }
        }
        if(sum<0)return -1;
        return ind;
    }
}