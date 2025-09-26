import java.util.*;

class Solution {
    public void rec(List<List<Integer>>ans,List<Integer>li,int index, int sum,int[] arr, int tar){
        if(sum==tar){
            ans.add(new ArrayList<>(li));
            return;
        }

        if(index==arr.length){
            return;
        }

        if((tar-sum) >= arr[index]){
            li.add(arr[index]);
            rec(ans,li,index,sum+arr[index],arr,tar);
            li.remove(li.size()-1);
        }
        
        rec(ans,li,index+1,sum,arr,tar);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        rec(ans,li,0,0,arr,target);
        return ans;
    }
}