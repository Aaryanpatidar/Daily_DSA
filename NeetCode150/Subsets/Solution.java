import java.util.*;

class Solution {
    void rec(List<List<Integer>>ans,List<Integer>li,int index,int n,int[] nums){
        if(index==n){
            ans.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[index]);
        rec(ans,li,index+1,n,nums);
        li.remove(li.size()-1);
        rec(ans,li,index+1,n,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>li= new ArrayList<>();
        int n = nums.length;
        rec(ans,li,0,n,nums);
        return ans;
    }
}