class Solution {
    public int[] twoSum(int[] arr, int t) {
        
        int ans[] = new int[2];
        int n =arr.length,s=0,e=n-1,sum;

        while(s<e){
            sum=arr[s]+arr[e];
            if(sum ==t){
                ans[0]=s+1;
                ans[1]=e+1;
                return ans;
            }else if(sum<t){
                s++;
            }else{
                e--;
            }
        }
        return ans;
    }
}