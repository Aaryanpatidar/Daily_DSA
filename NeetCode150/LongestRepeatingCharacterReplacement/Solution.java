class Solution {
    public int characterReplacement(String s, int k) {
        int map[] = new int[26];
        int l = 0, mfer = 0, ans = 0;
        for(int r = 0; r < s.length(); r++) {
            map[s.charAt(r)-'A']++;
            mfer = Math.max(mfer,map[s.charAt(r)-'A']);
            if((r-l+1)-mfer > k) {
               map[s.charAt(l) -'A']--;
                l++;
            }
            ans = Math.max(ans,(r-l+1));
        }
        return ans;
    }
}