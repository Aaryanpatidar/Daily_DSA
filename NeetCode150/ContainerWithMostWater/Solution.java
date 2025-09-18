class Solution {
    public int maxArea(int[] arr) {
        int n =  arr.length;
        int s=0,e = n-1,ans =0,water;
        while(s<e){
            water = Math.min(arr[s],arr[e])*(e-s);
            ans = (water>ans) ? water : ans;
            if(arr[s]<arr[e]){
                s++;
            }else{
                e--;
            }
        }
        return ans;
    }
}