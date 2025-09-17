import java.util.*;

class Pair {
    String word;
    int freq;

    Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq == b.freq) {
                    return b.word.compareTo(a.word); 
                }
                return a.freq - b.freq; 
            }
        );
        for(String s : map.keySet()) {
            Pair nxt = new Pair(s,map.get(s));
            minHeap.add(nxt);
            if(minHeap.size() > k)minHeap.poll();
        }

    List<String>ans = new ArrayList<>();
    while(!minHeap.isEmpty()) {
        Pair p = minHeap.poll();
        ans.add(p.word);
    }
    Collections.reverse(ans);
    return ans;
    }
}