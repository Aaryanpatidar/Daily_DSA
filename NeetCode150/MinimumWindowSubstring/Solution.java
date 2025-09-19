import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();

        for(int i =0; i<t.length(); i++){
            m1.put(t.charAt(i),m1.getOrDefault(t.charAt(i),0)+1);
        }

        int mini = Integer.MAX_VALUE,diff = m1.size(), ans_st=0,ans_end=0, st =0;

        for(int i =0; i<s.length(); i++) {
            
            char c = s.charAt(i);

            m2.put(c, m2.getOrDefault(c, 0) +1);
            if(m1.containsKey(c) && m1.get(c).intValue() == m2.get(c).intValue()){diff--;}
           
             while(diff == 0){ 
                int len = i-st+1;
                if(mini > len) {
                    mini =len;
                    ans_st=st;
                    ans_end=i;
                }
                char ch = s.charAt(st);
                m2.put(ch, m2.get(ch) -1);
                if (m1.containsKey(ch) && m2.get(ch).intValue() < m1.get(ch).intValue()) {
                    diff++;
                }
                st++;
             }
        }

        return mini == Integer.MAX_VALUE ? "" : s.substring(ans_st,ans_end+1);

    }
}