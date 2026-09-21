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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedListHead = (list1 == null && list2 == null) ? null : new ListNode();
        ListNode mergedList = mergedListHead;
        while(list1 != null && list2 != null) {
            ListNode next = new ListNode();
            if(list2.val < list1.val) {
                mergedList.val = list2.val;
                list2 = list2.next;
            } else {
                mergedList.val = list1.val;
                list1 = list1.next;
            }
            mergedList = mergedList.next = next;
        }
        while(list1 != null) {
            ListNode next = list1.next != null ? new ListNode() : null;
            mergedList.val = list1.val;
            mergedList = mergedList.next = next;
            list1 = list1.next;
        }
        while(list2 != null) {
            ListNode next = list2.next != null ? new ListNode() : null;
            mergedList.val = list2.val;
            mergedList = mergedList.next = next;
            list2 = list2.next;
        }
        return mergedListHead;
    }
}