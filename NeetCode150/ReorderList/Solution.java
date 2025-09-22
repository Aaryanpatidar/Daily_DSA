 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {

    public ListNode rev(ListNode s){
        if(s==null || s.next == null)return s;
        ListNode prev = null, cur = s,nxt=s;
        while(cur!=null){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    public void reorderList(ListNode head) {

        if(head.next == null || head.next.next == null){
            return ;
        }
        ListNode s = new ListNode(0,head);
        ListNode f = s;
        while(f!=null && f.next!= null){
            s = s.next;
            f = f.next.next;
        }
        ListNode e1 = s, h1 =head;
        s = s.next;
        e1.next = null;
        ListNode h2 = rev(s), n1, n2;
        while(h1 != null && h2!= null){
            n1= h1.next;
            n2=h2.next;
            h1.next=h2;
            h2.next=n1;
            h1=n1;
            h2=n2;
        }

    return;
    }
}