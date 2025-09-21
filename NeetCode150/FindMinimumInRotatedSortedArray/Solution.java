class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int s=0,e=n-1,mid;
        while(s<=e){
            mid= (s+e)/2;
            if(arr[mid]>=arr[e]){
                s=mid+1;
            }else{
                e=mid;
            }
        }
        return arr[e];
    }
}