import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)return "0";
        StringBuilder sb = new StringBuilder("");



        if((numerator<0)^(denominator<0)){
            sb.append("-");
        }
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        sb.append(n/d);
        n=n%d;
        if(n==0){
            return sb.toString();
        }
        sb.append(".");
        
        
        HashMap<Long,Integer> map = new HashMap<>();

        while(n!=0){
            if(map.containsKey(n)){
                sb.insert(map.get(n),"(");
                sb.append(')');
                return sb.toString();
            }
            map.put(n,sb.length());
            n = n*10;
            sb.append(n/d);
            n = n%d;
        }

        return sb.toString();
    }
}