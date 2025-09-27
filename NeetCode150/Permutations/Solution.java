import java.util.*;

class Solution {
  List<List<Integer>> ans = new ArrayList<>();
    public void rec(int []nums,int idx){
        if(idx == nums.length){
            List<Integer> ls = new ArrayList<>();
            for(int i : nums){
                ls.add(i);
            }
            ans.add(ls);
        }

        for(int i = idx; i< nums.length; i++){
            swap(nums, idx, i);
            rec(nums, idx+1);
            swap(nums, idx ,i);
        }
    }
    public void swap(int[]nums,int i,int idx){
        int j = nums[idx];
        nums[idx]=nums[i];
        nums[i]=j;
    }

    public List<List<Integer>> permute(int[] nums) {
        rec(nums,0);
        return ans;
    }
}