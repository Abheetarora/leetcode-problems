class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=new ListNode(0);
        temp.next=head; // 0->1->2->3->4
        ListNode curr=temp; 
        while(curr.next!=null && curr.next.next!=null){
            ListNode f_node=curr.next;
            ListNode s_node=curr.next.next;
            
            f_node.next=s_node.next; // 1->3
            curr.next=s_node; //0->2
            s_node.next=f_node; //2->1
            
            curr=curr.next.next;  // Similarly doing for otther nodes
        }
        return temp.next;  //2->1->4>3
    }
}