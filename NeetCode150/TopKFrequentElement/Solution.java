import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
           
        // int nl = nums.length;
        // List<Integer>[] temp = new List[nl+1];
       
        // for(int j=0;j<=nl;j++){
        //     temp[j]=new ArrayList<>();
        // }
        // for(int key : map.keySet()){
        //     temp[map.get(key)].add(key);
        // }
        // int [] res = new int[k];
        // int index=0;
        // for(int i =nl;i>0 && index<k ; i-- ){
        //     if(temp[i].size() !=0){
        //        for(int g : temp[i]){
        //         res[index++]=g;
        //         if(index==k){
        //             return res;
        //         }
        //        }
        //     }
        // }
        // return res;


        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int i : map.keySet()) {
            int [] nxt = new int[2];
            nxt[0]=i;
            nxt[1]=map.get(i);
            minHeap.add(nxt);
            if(minHeap.size() > k)minHeap.poll();
        }
        int i=0;
        int ans [] = new int[k];
        while(!minHeap.isEmpty()) {
            int arr[] = minHeap.poll();
            ans[i++] = arr[0];
        }
        return ans;
    }
}