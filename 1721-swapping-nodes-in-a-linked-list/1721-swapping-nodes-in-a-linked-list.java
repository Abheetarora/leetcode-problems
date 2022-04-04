class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode KthFromStart=head,out=head,KthFromLast=head;
        for(int i=1;i<k;i++){
            KthFromStart=KthFromStart.next;
        }
        ListNode temp_Node=KthFromStart;
        while(temp_Node.next!=null){
            temp_Node=temp_Node.next;
            KthFromLast=KthFromLast.next;
        }
        int temp= KthFromLast.val;
        KthFromLast.val=KthFromStart.val;
        KthFromStart.val=temp;
       return out;
    }
}