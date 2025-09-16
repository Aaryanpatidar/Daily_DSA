import java.util.HashMap;

class Solution {
    public static int[] twoSum(int[] arr, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< arr.length; i++) {
            if(map.containsKey(t-arr[i])) {
                return new int[]{map.get(t-arr[i]), i};
            }
            map.put(arr[i],i);
        }
        return new int[]{0,0};
    }

    public static void main (String[] args) {
        int [] arr = {3, 6, 8, 13, 7};
        int target = 15;
        
        int [] ans = twoSum(arr, target);
        System.out.println(ans[0]+ " "+ans[1]);
    }
}