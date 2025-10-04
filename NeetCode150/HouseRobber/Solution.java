class Solution {
    public int rob(int[] m) {
        int n = m.length;
        if(n==1){
            return m[0];
        }
        if(n==2){
            return Math.max(m[0],m[1]);
        }
        int a = m[0], b = m[1],c = m[2]+m[0],d =0;
        if(n==3){
            return Math.max(c,b);
        }

        for(int i = 3; i<n; i++){
            d = Math.max(a,b) + m[i];
            a = b;
            b = c;
            c = d;
        }
        
        return b>=c ? b : c;
    }
}