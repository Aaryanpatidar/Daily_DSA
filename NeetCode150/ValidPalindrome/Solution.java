class Solution {
    
    public String check(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder("");
        for (int i =0; i<n; i++) {
            char c = str.charAt(i);
            if((c>='a' && c<='z') || (c>='0' && c<='9')) {
                sb.append(c);
            }
            if(c>='A' && c<='Z') {
                char ch = (char)(c-'A'+'a');
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(String str) {
       String str1 = check(str);
       int s =0, e = str1.length()-1;
       while(s<e) {
            if(str1.charAt(s) != str1.charAt(e)){
                return false;
            }
            s++;e--;
       }
       return true;
    }
}