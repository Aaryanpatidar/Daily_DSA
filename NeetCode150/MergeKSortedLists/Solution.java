class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode mergeTwoList(ListNode ls1, ListNode ls2){
        if(ls2==null){  return ls1; }
        if(ls1 == null){ return ls2;  }
        ListNode h1 = ls1, h2=ls2,n1,n2;
        ListNode head = (h1.val<=h2.val) ? h1 : h2;
        while(h1 != null && h2!=null){
            n1 = h1.next;
            n2 = h2.next;
            if(h1.val <= h2.val){
                while(n1 != null && n1.val <= h2.val){
                    h1 = n1;
                    n1 = n1.next;
                }
                h1.next=h2;
                h1=n1;
            }else{
                while(n2!=null && n2.val < h1.val){
                    h2= n2;
                    n2 = n2.next;
                }
                h2.next=h1;
                h2=n2;
            }
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode x= null;
        if(lists.length == 0)return x;
        ListNode z = lists[0];
        for(int i =1; i<lists.length; i++){
            z =  mergeTwoList(z,lists[i]);
        }
        return z;
    }
}