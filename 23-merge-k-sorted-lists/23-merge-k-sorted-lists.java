class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }
    
    private ListNode merge(ListNode[] lists, int beg, int end) {
        if (beg == end)
            return lists[beg];
        
        if (beg > end)
            return null;
        
        int mid = (beg + end) / 2;
        ListNode left = merge(lists, beg, mid);
        ListNode right = merge(lists, mid + 1, end);
        return twomerge(left, right);
    }
    
    private ListNode twomerge(ListNode l1, ListNode l2) { 
        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            }
            
            else {
                result.next = l2;
                l2 = l2.next;
            }
            
            result = result.next;
            
        }
        
        while (l1 != null) {
            result.next = l1;
                        result = result.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            result.next = l2;
            result = result.next;
            l2 = l2.next;
        }
        return head.next;
    }
}