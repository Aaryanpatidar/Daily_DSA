
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class FindUnique{
    
      public static int[] sumZero(int n) {
        Set<Integer> set = new HashSet<>();
        int []ans = new int[n];
        int index =0;
        int sum =0;
        for(int i =n-1; i>0; i--) {
            ans[index] = i;
            sum += i;
            index++;
        }
        ans[index]= -sum;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] ans = sumZero(n);
        for (int i =0 ; i<n; i++) {
            System.out.print(ans[i]+ " ");
        }
    }
    
}