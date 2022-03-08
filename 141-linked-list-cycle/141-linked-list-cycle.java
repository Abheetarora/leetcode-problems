/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
        {
            return false;
        }
        ListNode slow = head;
         ListNode fast = head.next;
        while(fast!=null && slow!= null){
            if(fast == slow)
            {
                return true;
            }
            slow = slow.next;
            if(fast.next!= null)
            {
                fast= fast.next.next;
            }
            else
            {
                fast = null;
            }
        }
        return false;
    }
}