import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        pre[0]=1; suf[n-1]=1;

        for(int i = 1; i<n; i++){
            pre[i] = pre[i-1]*arr[i-1];
            suf[n-i-1] = suf[n-i]*arr[n-i];
            ans[i]= ans[i]*pre[i];
            ans[n-i-1]= ans[n-i-1]*suf[n-i-1];
        }
    return ans;
    }
}