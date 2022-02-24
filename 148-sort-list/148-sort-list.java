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
    public ListNode sortList(ListNode head) {
         if(head==null||head.next==null){
             return head;
         }
    
       ListNode mid1=mid(head);
         ListNode right=sortList(mid1.next);
        mid1.next=null;
        ListNode left= sortList(head);
       
        return sorthelper(left,right);
        
    }
    public ListNode sorthelper(ListNode left,ListNode right){
    
    if(left==null)
    {
      return right; 
     
    }
        if(right==null)
    {
         
            return left;
            
    }
    
        if(left.val<=right.val){
     
          left.next=sorthelper(left.next,right);
          return left;
        }
  
        right.next=sorthelper(left,right.next);
       
      return right;
    }
      //  }
        //return sorted.next;
        
        

    public ListNode mid(ListNode head){
        if(head==null){
            return head;
        }
        
        ListNode slow= head;
        ListNode fast= head;
        while(fast.next!=null && fast.next.next!=null){
           
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
    
}