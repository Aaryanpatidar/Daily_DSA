class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length, ans =1; 
        int [] dp = new int[n];
        dp[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            int maxi = 0;
            for(int j = i+1; j<n; j++){
                if(arr[i]<arr[j]){
                    maxi = Math.max(maxi, dp[j]);
                }
            }
            dp[i]=maxi+1;
            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
}