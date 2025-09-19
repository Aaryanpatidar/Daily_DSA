class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1= s1.length(),n2=s2.length();

        if(n1>n2)return false;

        int m1[] = new int[26];
        int m2[] = new int[26];

        for(int i =0 ;i<n1;i++){
            m1[s1.charAt(i) - 'a']++;
            m2[s2.charAt(i) - 'a']++;
        }

        int diff =0;

        for(int i =0;i<26;i++){
            if(m1[i]!=m2[i]){
                diff++;
            }
        }

        if(diff==0)return true;
        int st =0;

        for(int j = n1; j<n2; j++){

           char c1 = s2.charAt(st);
           char c2 = s2.charAt(j);

           if(m1[c1-'a'] == m2[c1-'a']){
            diff++;
           }else if(m1[c1-'a'] == (m2[c1-'a']-1)){
            diff--;
           }
           m2[c1-'a']--;st++;

           if(m1[c2-'a']==m2[c2-'a']){
            diff++;
           }else if(m1[c2-'a'] == (m2[c2-'a'] +1)){
            diff--;
           }
           m2[c2-'a']++;
           
           if(diff==0)return true;
        }
        return diff==0;
    }
}