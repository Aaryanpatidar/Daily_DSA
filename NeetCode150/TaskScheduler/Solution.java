import java.util.*;

class Pair1{
    char c;
    int freq;
    public Pair1(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}

class Solution {
    public int leastInterval(char[] arr, int n) {
        int [] freq = new int[26];
        int [] time = new int[26];
        int ans =0;
        PriorityQueue<Pair1> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        for(char c: arr){
            freq[c - 'A']++;
        }
        for(int i =0; i<26; i++){
            if(freq[i]>0){
                Pair1 p = new Pair1((char)('A'+i),freq[i]);
                pq.add(p);
            }
        }
        for(int i =0 ;i<26; i++){
            if(freq[i]>0){Pair1 p = new Pair1((char)(i+'A'), freq[i]);}
        }

        while(!pq.isEmpty()){
            ArrayList<Pair1>temp = new ArrayList<>();
            while(!pq.isEmpty() && time[pq.peek().c-'A'] > 0){
                temp.add(pq.remove());
            }
            if(!pq.isEmpty()){
                Pair1 p = pq.remove();
                if(p.freq > 1){
                    Pair1 p2 = new Pair1(p.c, (p.freq-1));
                    time[p.c - 'A'] = n+1;
                    pq.add(p2);
                }
            }
            while(!temp.isEmpty()){
                pq.add(temp.remove(temp.size()-1));
            }
            for(int i =0 ;i<26;i++){
                time[i]--;
            }
            ans++;
        }
        return ans;
    }
}