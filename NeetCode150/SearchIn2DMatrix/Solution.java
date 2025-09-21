class Solution {
    public boolean searchMatrix(int[][] arr, int key) {
        int mi = arr.length,n=arr[0].length, rs =0,re=mi-1;
        while(rs<re){
            int m =(rs+re)/2;
            if(arr[m][0]<=key && key<=arr[m][n-1]){rs=m; break;}
            if(arr[m][n-1]>=key){re=m;}

            if(key<arr[m][0]){
                re = m-1; 
            }else{
                rs = m+1; 
            }
        }

        if(rs<0 || rs>=mi) return false;

        int cs =0,ce=n-1;
        while(cs<=ce){
            int m=(cs+ce)/2;
            if(arr[rs][m]==key){return true;
            }else if(arr[rs][m]<key){cs=m+1;
            }else{ce=m-1;}
        }
        return false;

    //    int m = arr.length,n=arr[0].length,s=0,e=(m*n)-1;
    //     while(s<=e){
    //         int mid = s+(e-s)/2;
    //         int r= mid/n,c=mid%n;
    //         if(arr[r][c]==key){
    //             return true;
    //         }else if(arr[r][c]>key){
    //              e=mid-1;
    //         }else if(arr[r][c]<key){
    //             s=mid+1;
    //         }
    //     }
    //     return false;
    }
}