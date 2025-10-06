class Solution {
    
    public boolean canJump(int[] arr) {
        // int n = arr.length;
        // boolean dp[]=new boolean[n];
        // dp[n-1]=true;
        // for(int i =n-2; i>=0; i--){
        //     for(int j =1; j<=arr[i]; j++){
        //         if(dp[i+j] == true){
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // } 
        // return dp[0];

        int maxi = 0;
        int n = arr.length;
        for(int i = 0; i<n; i++){
            if(i>maxi)return false;
            maxi = Math.max(maxi, (i+arr[i]));
            if(maxi>=n-1){
                return true;
            }
        }
        return true;
    }
}