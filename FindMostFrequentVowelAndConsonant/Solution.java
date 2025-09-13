import java.util.HashMap;


class Solution {
    public static int maxFreqSum(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('a', 0);
        mp.put('e', 0);
        mp.put('i', 0);
        mp.put('o', 0);
        mp.put('u', 0);
        int i =0, n = s.length();

        HashMap<Character, Integer> cons = new HashMap<>();
        
        while(i<n) {
            char c = s.charAt(i);
            if(mp.containsKey(c)) {
                mp.put(c,mp.get(c)+1);
            }else {
                cons.put(c,cons.getOrDefault(c,0)+1);
            }
            i++;
        }
        int ans =0;
        int v=0, con = 0;
        for(char c : mp.keySet()) {
            v = Math.max(v,mp.get(c));
        }
        ans+=v;
        for(char c: cons.keySet()) {
            con = Math.max(con,cons.get(c));
        }
        ans+=con;

        return ans;
    }

    public static void main(String[] args) {
        String s = "avdjhsiauatqcrrbtirisxxtycnakx";
        int ans = maxFreqSum(s);
        System.out.println(ans);
    }

}

