class Solution {
    public int maxProfit(int[] arr) {
        int s =arr[0];
        int ans =0;
        for(int i =1;i<arr.length;i++){
            if(arr[i]<s) {
                s=arr[i];
            }else {
                ans = Math.max(ans, arr[i]-s);
            }    
        }
        return ans;
    }
}