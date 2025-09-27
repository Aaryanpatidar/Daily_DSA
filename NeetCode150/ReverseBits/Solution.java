class Solution {
    public int reverseBits(int n) {
        int ans =0, temp = n;
        for(int i =0 ; i<32; i++){
            ans = ans<<1;
            int bit = temp & 1;
            ans = ans | bit;
            temp = temp / 2;
        }
        return ans;
    }
}