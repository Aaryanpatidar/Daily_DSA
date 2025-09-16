class Solution {
    public static boolean isAnagram(String s1, String s2) {
       int [] arr = new int[26];
       if(s1.length() != s2.length())return false;
       for(int i =0; i<s1.length(); i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            arr[x]++;arr[y]--;
       }
       for(int i =0; i<26; i++) {
            if(arr[i] != 0)return false;
       }
       return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", s2 = "nagaram";
        boolean ans = isAnagram(s1,s2);
        System.out.println("Strings are anagram : "+ ans );
    }
}