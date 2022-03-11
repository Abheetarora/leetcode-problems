/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
            if(head == null || k == 0){
                return head;
            }
        ListNode temp = head;
        int len = 0;
        while(temp.next!=null){
            temp = temp.next;
            len++;
        }
      len++;
        temp.next = head;
       // temp = temp.next;
        int n = len - k % len;
        temp = head;
        while(n-->1)
        {
            temp=temp.next;
            
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}