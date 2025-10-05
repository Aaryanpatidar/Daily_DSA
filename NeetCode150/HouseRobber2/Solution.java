class Solution {
    public int rob1(int[] m ,int s, int e) {
        int n = m.length;
        if((n-s) == 1){
            return m[s];
        }
        if((n-s)==2){
            return Math.max(m[s],m[s+1]);
        }
        int a = m[s], b = Math.max(m[s],m[s+1]), c;
        
        for(int i = (s+2); i<e; i++){
            c = Math.max(b, (a+m[i]));
            a = b;
            b = c;
        }
        
        return b;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob1(nums,0,n-1),rob1(nums,1,n));
    }
}

