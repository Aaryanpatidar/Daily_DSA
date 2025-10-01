class Solution {
    int m;
    int n;

    public boolean rec(char[][] arr, String word,int i, int j, int ind){
        if(ind == word.length()){
            return true;
        }
        
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        if(arr[i][j] != word.charAt(ind)){
            return false;
        }
        if(arr[i][j] == '#'){
            return false;
        }
        
        char ch = arr[i][j];
        arr[i][j] = '#';
        boolean ans = rec(arr,word,i,j+1,ind+1) || rec(arr,word,i+1,j,ind+1) || rec(arr,word,i,j-1,ind+1) || rec(arr,word,i-1,j,ind+1);
        arr[i][j] = ch;
       
       return ans;
    }

    public boolean exist(char[][] arr, String word) {
        m = arr.length;
        n = arr[0].length;
        
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
               if( rec(arr,word,i,j,0)){
                return true;
               }
            }
        }
        return false;
    }
}