class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public Node(int val, Node x){
        this.val = val;
        this.next = x;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node h1 = head;

        while(h1!=null){
            Node x = new Node(h1.val,h1.next);
            h1.next = x;
            h1 = h1.next.next;
        }

        h1=head;

        while(h1!=null){
            if(h1.random==null){
                h1.next.random=null;
            }else{
                h1.next.random = h1.random.next;
            }
             h1= h1.next.next;
        }

        h1=head;
        Node head2 = head.next,h2 = head.next;

        while(h1!=null){
            h1.next = h2.next;
            h1 = h1.next;
            if(h1!=null){
                h2.next = h1.next;
                h2 = h2.next;
            }
        }
        return head2;
    }
}