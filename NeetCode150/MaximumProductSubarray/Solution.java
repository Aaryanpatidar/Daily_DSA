class Solution {
    public int maxProduct(int[] arr) {
        int prod = 1, n = arr.length, ans = Integer.MIN_VALUE;

        for(int i =0; i<n; i++){
            if(arr[i] == 0){
                prod = 1;
                ans = Math.max(ans,0);
                continue;
            }
            prod = prod * arr[i];
            ans = Math.max(ans,prod);
        }
        prod = 1;

        for(int i = n-1; i>=0; i--){
            if(arr[i] == 0){
                prod = 1;
                ans = Math.max(ans,0);
                continue;
            }
            prod = prod * arr[i];
            ans = Math.max(ans,prod);
        }
        return ans;
    }
}