class Solution {
    public int search(int[] arr, int t) {
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
        int pivot = e;
        s=0; e=n-1;
        if(t<=arr[e]){
            s=pivot;
        }else{
            e= pivot-1;
        }
        
        while(s<=e){
            mid = (s+e)/2;
            if(arr[mid]==t){
                return mid;
            }else if(arr[mid]>t){
                e=mid-1;
            }else{
                s=mid+1;
            }

        }
        return -1;
    }
}