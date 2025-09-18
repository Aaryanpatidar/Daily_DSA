class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lm [] = new int[n];
        int ans = 0, rm = arr[n-1];
        lm[0] = arr[0];
        for(int i = 1; i<n; i++) {
            lm[i] = Math.max(lm[i-1], arr[i]);
        }
        for(int i = n-1; i >= 0; i--) {
            rm = Math.max(rm , arr[i]);
            lm[i]= Math.min(rm , lm[i]);
            ans+=Math.max(0,(lm[i]-arr[i]));
        }
        return ans;
    }
}