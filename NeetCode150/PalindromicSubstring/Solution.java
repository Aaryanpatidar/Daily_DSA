class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean temp[][] = new boolean[n][n];
        
        int maxi = 0;
       

        for(int i =0, j =0; i<n; i++, j++){
            temp[i][j] = true;
            maxi++;
        }

        for(int i =0, j=1; j<n; i++,j++){
            if(s.charAt(i) == s.charAt(j)){
                temp[i][j] = true;
                maxi++;
            }
        }

        for(int t = 2; t<n; t++){
            for(int i =0, j=t; j<n; j++, i++){
                if((s.charAt(i) == s.charAt(j)) && temp[i+1][j-1]){
                    temp[i][j] = true;
                    maxi++;
                }
            }
        }

        return maxi;
    }
}