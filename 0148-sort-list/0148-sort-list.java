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
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head)
    {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!= null && fast.next!= null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(slow);
        ListNode ans = merge(head1,head2);
        return ans;
    }
    public ListNode merge(ListNode head1 , ListNode head2)
    {
        ListNode anshead = new ListNode(-1);
        ListNode anstail = anshead;
        while(head1!=null && head2 != null)
        {
            if(head1.val <= head2.val)
            {
                anstail.next = new ListNode(head1.val);
                head1 = head1.next;
            }
            else
            {
                anstail.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            anstail = anstail.next;
        }
        while(head1!=null)
        {
            anstail.next = new ListNode(head1.val);
            head1 = head1.next;
            anstail = anstail.next;
        }
        while(head2!=null)
        {
            anstail.next = new ListNode(head2.val);
            head2 = head2.next;
            anstail = anstail.next;
        }
        ListNode t1 = anshead;
        anshead = anshead.next;
        t1.next = null;
        return anshead;
    }
}