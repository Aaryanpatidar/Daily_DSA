class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode reverseKGroup(ListNode x, int k) {
        ListNode temp =x;
        int cnt =0;
        while(temp!=null && cnt<k){
            temp=temp.next;
            cnt++;
        }
        if(cnt<k)return x;
        ListNode prev =null,cur = x,nxt=x;
        while(cur!=temp){
            nxt = cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        x.next = reverseKGroup(temp,k);
        return prev;
    }
}