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

/*
[0,1,2,3]
1->0, temp = next
2->1
3->2
head=3

*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode reverseListHead = reverseList(next);
        head.next = null;
        next.next = head;
        return reverseListHead;
    }
}
