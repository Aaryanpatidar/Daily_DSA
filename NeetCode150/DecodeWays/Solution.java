class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int a =1, b =1,c;

        for(int i = 1; i<s.length(); i++){

            if(s.charAt(i) == '0'){

                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    c =a;
                }else{
                    return 0;
                }

            }else if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i)<'7')){
                c = a+b;
            }else{
                c = b;
            }
           
            a = b;
            b= c;
        }

        return b;
    }
}