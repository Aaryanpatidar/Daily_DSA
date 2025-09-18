import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        int i = 0, j, k;
        while(i < n-2) {
            j=i+1;k=n-1;
            int tar = -arr[i];
            while(j<k) {
                int sum = arr[j]+arr[k];
                if(sum==tar) {
                    List<Integer>temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    ans.add(temp);
                    j++;
                    while(j<n && arr[j]==arr[j-1]){
                        j++;
                    }
                    k--;
                    while(k>0 && arr[k]==arr[k+1]){
                        k--;
                    }
                }else if(sum<tar) {
                    j++;
                    while(j<n && arr[j]==arr[j-1]){
                        j++;
                    }
                }else {
                    k--;
                    while(k>0 && arr[k]==arr[k+1]){
                        k--;
                    }
                }
            }
            i++;
            while(i<n-1 &&  arr[i]==arr[i-1]) {i++;}
            
        }

        // for(int i=0;i<n;i++){
        //     if(arr[i]>0)break;
        //     if(i>0 && (arr[i]==arr[i-1]))continue;
        //     int j = i+1, k = n-1;
        //     while(j<k){
        //         int sum = arr[i]+arr[j]+arr[k];
        //         if(sum==0){
        //             List<Integer> r = new ArrayList<>();
        //             r.add(arr[i]);
        //             r.add(arr[j]);
        //             r.add(arr[k]);
        //             rs.add(r);
        //             j++;
        //             k--;
        //             while(j<k && arr[j]==arr[j-1]){
        //             j++;
        //         }
        //         }else if(sum<0){
        //             j++;
        //         }else{
        //             k--;
        //         }
                
        //     }
        // }

     
        return ans;
    }
}