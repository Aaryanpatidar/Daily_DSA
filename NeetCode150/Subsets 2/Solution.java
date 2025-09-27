import java.util.*;

class Solution {
    List<List<Integer>> ans;
    List<Integer> temp;

    public void rec(int[] nums, int index){
        ans.add(new ArrayList<>(temp));
        
        for(int i = index; i < nums.length; i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            rec(nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        rec(nums, 0);
        return ans;
    }
}