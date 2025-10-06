class Solution {
    public int maxSubArray(int[] arr) {
        int sum =0,n = arr.length, ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            sum = sum + arr[i];
            ans = Math.max(ans,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        sum =0;
        for(int i = n-1; i>=0; i--){
            sum = sum + arr[i];
            ans = Math.max(ans,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        
        return ans;
    }
}