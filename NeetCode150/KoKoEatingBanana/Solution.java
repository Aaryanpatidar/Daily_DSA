class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int n=arr.length,maxi = -1;

        for(int i =0; i<n; i++){
            maxi = Math.max(maxi,arr[i]);
        }

        int s=1, e = maxi,ans=e,m;
        while(s<=e){
            m =(s+e)/2;
            long t=0;
            for(int i =0; i<n;i++){
                t+=((arr[i]-1)/m) +1;
            }
            if(t<=h){
                ans=Math.min(ans,m);
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;
    }
}