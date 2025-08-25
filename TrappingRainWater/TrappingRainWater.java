class TrappingRainWater {

    public static int trapRainWater(int arr[]){
        int n = arr.length, ans =0;
        int check[] = new int[n];
        int maxi  = 0;
        for(int i=0; i<n; i++) {
            maxi = Math.max(arr[i], maxi);
            check[i] = maxi;
        }
        maxi =0;
        for(int i =n-1; i>=0; i--) {
            maxi = Math.max(arr[i],maxi);
            check[i] = Math.min(check[i], maxi);
        }
        for(int i=0; i<n; i++ ) {
            ans+= check[i]-arr[i];
            System.out.print(check[i]-arr[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1,6,2,3,7,5,8,0,3,1,2,1,9,12,7,2,5}; 
        int result = trapRainWater(arr);
        System.out.println(result);
    }

}