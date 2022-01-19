public class Solution {
    public ListNode detectCycle(ListNode head) {
        //idea from the fast-slow pointer method to check wether their is a cycle.
        if (head == null || head.next == null){
            return null;
        }
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode laterNode = head;
                while (laterNode != slow) {
                    laterNode = laterNode.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}