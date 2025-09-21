class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        
        int s = 0, e=m, px, py;
        while(s<=e){
            px = s + (e-s)/2;
            py = (m+n+1)/2 - px;

            int a1 = (px == 0) ? Integer.MIN_VALUE : nums1[px-1];
            int b1 = (py == 0) ? Integer.MIN_VALUE : nums2[py-1];
            int a2 = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int b2 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            if(a1<=b2 && b1<=a2) {
                if((m+n)%2 == 1){
                    return Math.max(a1,b1);
                }
                return (Math.max(a1,b1)+Math.min(a2,b2))/2.0;
            }

            if(a1>b2){
                e=px-1;
            }else{
                s=px+1;
            }

        }
        return -1;
    }
}