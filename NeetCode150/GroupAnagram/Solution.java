import java.util.*;

class Solution {
    public boolean check(String s1, String s2) {
        int [] arr = new int[26];
        if(s1.length() != s2.length())return false;
        for(int i =0; i<s1.length(); i++) {
                int x = s1.charAt(i) - 'a';
                int y = s2.charAt(i) - 'a';
                arr[x]++;arr[y]--;
        }
        for(int i =0; i<26; i++) {
                if(arr[i] != 0)return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> dummy = new ArrayList<>();
        int i =0;
        while(i<strs.length) {
            boolean isput = false;
            for(int j =0; j<dummy.size(); j++ ) {
                if(check(strs[i], dummy.get(j).get(0))) {
                    dummy.get(j).add(strs[i]);
                    isput=true;
                    break;
                }
            }
            if(!isput){
                List<String> st = new ArrayList<>();
                st.add(strs[i]);
                dummy.add(st);
            }
            i++;
        }
        return dummy;
        // Map<String,List<String>> map = new HashMap<>();
        // List<List<String>> res = new ArrayList<>();
        // for(int i =0;i<strs.length;i++){
        //     int arr [] = new int[26];
        //     String s = strs[i];
        //     for(char c : s.toCharArray()){
        //         arr[c-'a']++;
        //     }
        // String str = Arrays.toString(arr);
        // map.putIfAbsent(str,new ArrayList<String>());
        // map.get(str).add(s);
        // }
        // for(String st : map.keySet()){
        //     res.add(map.get(st));
        // }
        // return res;
    }
}