class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null,h3=null, h1 = l1, h2 = l2;

        int carry =0,sum,digit;
        while(h1!=null && h2!=null){
            sum = h1.val + h2.val + carry;
            digit = sum%10;
            carry = sum/10;
            ListNode x = new ListNode(digit);
            if(head == null){
                head = x;
                h3=x;
            }else{
                h3.next = x;
                h3 = h3.next;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        while(h1!=null){
            sum = h1.val + carry;
            digit = sum%10;
            carry = sum/10;
            ListNode x = new ListNode(digit);
            if(head == null){
                head = x;
                h3=x;
            }else{
                h3.next = x;
                h3 = h3.next;
            }
            h1 = h1.next;
        }

        while(h2!=null){
            sum = h2.val + carry;
            digit = sum%10;
            carry = sum/10;
            ListNode x = new ListNode(digit);
            if(head == null){
                head = x;
                h3=x;
            }else{
                h3.next = x;
                h3 = h3.next;
            }
            h2 = h2.next;
        }

        if(carry>0){
            ListNode x = new ListNode(carry);
            h3.next = x;
        }

        return head;
    }
}