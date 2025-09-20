import java.util.*;

class Solution {
    public int largestRectangleArea(int[] arr) {
        int n =arr.length;
        Stack<int []> stk = new Stack<>();
        Stack<int []> stk2 = new Stack<>();
        int ls[] = new int[n];
        int rs[] = new int[n];
        ls[0] = -1;
        rs[n-1]=n;
        stk.push(new int[]{arr[0],0});
        stk2.push(new int[]{arr[n-1],n-1});
        for(int i =1; i<n; i++){
            while(!stk.isEmpty() && stk.peek()[0] >= arr[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                ls[i] = -1;
            }else {
                int arr1[] = stk.peek();
                ls[i]=arr1[1];
            }
            stk.push(new int[]{arr[i],i});
            
        }

        for(int i =n-2; i>=0; i--){
            while(!stk2.isEmpty() && stk2.peek()[0] >= arr[i]){
                stk2.pop();
            }
            if(stk2.isEmpty()){
                rs[i] = n;
            }else {
                int arr1[] = stk2.peek();
                rs[i]=arr1[1];
            }
            stk2.push(new int[]{arr[i],i});
           
        }

        int ans =0;
        for(int i=0; i<n; i++){
            int b = rs[i]-ls[i]-1;
            int mul = arr[i]*b;
            ans = Math.max(ans, mul);
        }

        return ans;


        // int n =arr.length;
        // int ko[] = new int[n];
        // Stack<Integer> stk = new Stack<>();
        // Stack<Integer> stk2 = new Stack<>();
        // for(int i=n-1; i>=0; i--){
        //     while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
        //         stk.pop();
        //     }
        //     if(stk.isEmpty()){
        //         if(i<n-1){
        //             if(arr[i]<=arr[i+1]){
        //                 ko[i]=n-1-i;
        //                 stk.push(i);
        //                 continue;
        //             }
        //         }
        //         ko[i]=0;
        //         stk.push(i);
        //     }else{
        //         ko[i]=stk.peek()-i-1;
        //         stk.push(i);
        //     }
        // }
        
        // for(int i =0;i<n ;i++){
        //     while(!stk2.isEmpty() && arr[stk2.peek()]>=arr[i]){
        //         stk2.pop();
        //     }
        //     if(stk2.isEmpty()){
        //         if(i>0){
        //             if(arr[i]<=arr[i-1]){
        //                 ko[i]=ko[i]+i;
        //                 stk2.push(i);
        //                 continue;
        //             }
        //         }
        //        stk2.push(i);
        //     }else{
        //         ko[i]=ko[i]+i-stk2.peek()-1;
        //         stk2.push(i);
        //     }
        // }
        
        // int ans =0,mul =0;
        // for(int i=0;i<n;i++){
        //      mul = arr[i]*(ko[i]+1);
        //     if(ans<mul){
        //         ans=mul;
        //     }
        // }
        // return ans;
    }
}