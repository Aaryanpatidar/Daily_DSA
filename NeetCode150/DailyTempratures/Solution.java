import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int [] ans = new int[n];
        Stack<int []> stk = new Stack<>();
        ans[n-1]=0;
        stk.push(new int[]{temp[n-1],n-1});

        for(int i =n-2; i>=0; i--){
            while(!stk.isEmpty() && stk.peek()[0] <= temp[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                ans[i]=0;
            }else{
                int arr[] = stk.peek();
                ans[i] = arr[1] - i;
            }
            stk.push(new int[]{temp[i],i});
        }

        return ans;

        // Pushing Index -->
        // int n = temp.length;
        // int [] ans = new int[n];
        // Stack<Integer> stk = new Stack<>();
        // for(int i =n-1; i>=0; i--){
        //    while(!stk.isEmpty() && temp[stk.peek()]<=temp[i]){
        //     stk.pop();
        //    }
        //    if(stk.isEmpty()){
        //     ans[i]=0;
        //    }else{
        //     ans[i] = stk.peek() - i;
        //     }
        //     stk.push(i);
        // }
        // return ans;
    }
}