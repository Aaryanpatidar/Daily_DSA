import java.util.HashSet;

class Solution {
    public static boolean containsDuplicate(int[] arr) {
       HashSet<Integer> set = new HashSet<>();
       for(int i: arr) {
        if(set.contains(i))return true;
        set.add(i);
       }
       return false;
    }
    public static void main(String []args) {
        int []arr = {3, 5, 1, -1 , 3, 8};
        boolean ans = containsDuplicate(arr);
    }
}