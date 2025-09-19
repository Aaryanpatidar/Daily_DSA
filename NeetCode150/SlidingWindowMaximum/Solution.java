import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
     
        PriorityQueue <int []> pq = new PriorityQueue<>((a,b) -> b[0] - a[0] );
        int n = arr.length;
        int ans[]= new int[n-k+1];
        for(int i=0;i<k;i++){
            pq.add(new int[]{arr[i],i});
        }
        ans[0]=pq.peek()[0];
        int index =1;
        for(int i = k; i<n; i++){
            pq.add(new int[]{arr[i],i});
            while(pq.peek()[1]<=i-k){
                    pq.poll();
            }
            ans[index++] = pq.peek()[0];
        }
        return ans;
        
        // int n = arr.length;
        // int la[]= new int[n];
        // int ra[]= new int[n];
        // int ans[] = new int[n-k+1];
        // la[0]=arr[0];
        // ra[n-1]=arr[n-1];
        // for(int i =1; i< n; i++){
        //     if(i%k ==0){
        //         la[i]=arr[i];
        //     }else{
        //         la[i]=Math.max(arr[i],la[i-1]);}
        //     if((n-1-i)%k == 0){
        //         ra[n-i-1] = arr[n-1-i];
        //     }else{    
        //       ra[n-i-1]=Math.max(arr[n-i-1],ra[n-i]);}
        // }
        // for(int i = 0 ; i<n-k+1; i++){
        //     ans[i]=Math.max(ra[i],la[i+k-1]);
        // }
        
        // return ans;
    }
}