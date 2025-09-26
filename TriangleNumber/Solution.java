import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length,ans =0;

        for(int l=0; l < n-2; l++){
            for(int m = l+1; m<n-1; m++){
                int r = n-1;
                int sum = nums[l]+nums[m];
                while(r>m && sum<=nums[r]){
                    r--;
                }
                ans+=(r-m);
            }
        }
        return ans;
    }
}