class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length, i =0, j=0, ans =0;
        int n2 = v2.length;
        
        while(i<n1 && j<n2){
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[j]);
            if(a<b){
                ans--;
                break;
            }
            if(a>b){
                ans++;
                break;
            }
            i++;
            j++;
        }

        while(ans ==0 && i<n1){
            int a = Integer.parseInt(v1[i]);
            int b = 0;
            if(a<b){
                ans--;
            }
            if(a>b){
                ans++;
            }
            i++;
            j++;
        }

        while(ans ==0 && j<n2){
            int a = 0;
            int b = Integer.parseInt(v2[j]);
            if(a<b){
                ans--;
            }
            if(a>b){
                ans++;
            }
            i++;
            j++;
        }

        if(ans>0){
            return 1;
        }
        if(ans<0){
            return -1;
        }
        return 0;
    }
}