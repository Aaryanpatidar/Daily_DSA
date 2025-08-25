class PivotFind {

    public static int pivotFind(int arr[]) {
        int n = arr.length;
        if(arr[0] <= arr[n-1]) {
            return 0;
        }
        int s=0, e=n-1,m=0;
        while(s<e) {
            
            m = (s+e)/2;
            if(arr[m]>=arr[s]) { 
               s=m+1;
            }
            if(arr[m]<arr[e]) {
                e=m;
            }
            
        }
        return e;
    }

    public static void main (String args[]) {
        int arr[] = {3,4,0};
        int index = pivotFind(arr);
        System.out.print(index);
    }

}