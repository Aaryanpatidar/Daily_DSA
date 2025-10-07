class Solution {
    public int gcd(int a, int b){
        if(b>a){
            return gcd(b,a);
        }
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public int findGCD(int[] arr) {
        
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            if(arr[i]<a)a=arr[i];
            if(arr[i]>b)b=arr[i];
        }
        return gcd(a,b);
    }
}