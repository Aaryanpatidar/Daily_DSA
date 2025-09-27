class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0]=0;
        if(n==0)return ans;
        ans[1]=1;
        int lp = 1, up =2;
        for(int i =2; i<=n; i++){
            if(i==up){
                lp=up;
                up = up*2;
            }
            ans[i]=ans[i%lp] +1;
        }  
        return ans;   
    }
}