import java.util.*;

class Solution {

    PriorityQueue<int[]> pq;
    HashMap<Integer,Integer>ttou;
    HashMap<Integer,Integer>ttop;
    public Solution(List<List<Integer>> tasks) {
      pq = new PriorityQueue<>((a,b) -> a[2] != b[2] ? b[2]-a[2] : b[1]-a[1]);
      ttou = new HashMap<>();
      ttop = new HashMap<>();
      for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.offer(new int[]{userId, taskId, priority});
        ttop.put(taskId, priority);
        ttou.put(taskId, userId);
    }
    
    public void edit(int taskId, int newPriority) {
        if (!ttou.containsKey(taskId)) return;  
        int userId = ttou.get(taskId);
        pq.offer(new int[]{userId, taskId, newPriority});
        ttop.put(taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        ttop.remove(taskId);
        ttou.remove(taskId);
    }
    
    public int execTop() {
        while (!pq.isEmpty()) {
        int[] top = pq.peek();
        int priority = top[2], taskId = top[1], userId = top[0];
        Integer curP = ttop.get(taskId);
        Integer curU = ttou.get(taskId);
        if (curP == null || curU == null || curP != priority || curU != userId) {
            pq.poll(); 
            continue;
        }
        pq.poll();
        ttop.remove(taskId);
        ttou.remove(taskId);
        return userId;
        }
        return -1;
    }
}