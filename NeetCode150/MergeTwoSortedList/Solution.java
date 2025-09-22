class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {

        if(h1==null)return h2;
        if(h2==null)return h1;

        ListNode head, n1, n2;
        if(h1.val<=h2.val){
            head = h1;
        }else{
            head = h2;
        }

        while(h1!=null && h2!=null){
            n1=h1.next;
            n2=h2.next;
            if(h1.val<=h2.val){
                while(n1 != null && n1.val<=h2.val){
                    h1=h1.next;
                    n1=n1.next;
                }
                h1.next = h2;
                h1=n1;
            }else{
                while(n2 != null && n2.val<h1.val){
                    h2=h2.next;
                    n2=n2.next;
                }
                h2.next = h1;
                h2=n2;
            }
        }

        return head;
    }
}