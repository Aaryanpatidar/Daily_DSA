import java.util.*;

class Solution {
    public void rec(List<List<Integer>>ans,List<Integer>li,int index,int[] arr, int tar){
        if(tar < 0){ return;}
        if(tar == 0){ ans.add(new ArrayList<>(li));}
        
        for(int i = index; i<arr.length; i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            li.add(arr[i]);
            rec(ans,li,i+1,arr,tar-arr[i]);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        rec(ans,li,0,arr,target);
        return ans;
    }
   
}