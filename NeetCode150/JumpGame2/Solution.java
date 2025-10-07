class Solution {
    public int jump(int[] arr) {

        int ans =0, j =0, range = 0;

        for(int i =0; i<arr.length-1; i++){
            range = Math.max(range,(i+arr[i]));
            if(i == j){
                ans++;
                j = range;
            }
        }

        return ans;

        // O(n2)
        // int n = arr.length;
        // if(n==1)return 0;
        // int dp[]=new int[n];
        // dp[n-1] = 0;
        // for(int i = n-2; i>=0; i--){
        //     int a = Integer.MAX_VALUE;
        //     for(int j = i+1; j<=Math.min(n-1,(i+arr[i])); j++){
        //         a = Math.min(a,dp[j]);
        //     }
        //     if(a == Integer.MAX_VALUE){
        //         dp[i] = Integer.MAX_VALUE;
        //     }else{
        //         dp[i] = a+1;
        //     }
        // }
        // return dp[0];
    }
}