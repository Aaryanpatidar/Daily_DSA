
import java.util.Scanner;

class AliceandBob{
    public static  long flowerGame(int n, int m) {
        long ans = 0;
        long ne1=n/2, ne2=m/2,no1,no2;
        if(n%2==0){
            no1=n/2;
        }else{
            no1=(n/2)+1;
        }

        if(m%2==0){
            no2=m/2;
        }else{
            no2=(m/2)+1;
        }

        long a = ne1*no2;
        long b = ne2*no1;
        ans = a+b;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(), m=sc.nextInt();
        long ans = flowerGame(n,m);
        System.out.println(ans);
    }
}