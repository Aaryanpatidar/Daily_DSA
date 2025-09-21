class Solution {
    public int search(int[] arr, int target) {
        int s= 0,e= arr.length-1,mid;
        
        while(s<=e){
            mid = (e+s)/2;
        
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]<target){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return -1;
    }
}