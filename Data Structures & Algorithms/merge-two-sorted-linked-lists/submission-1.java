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
        if(list1 == null && list2 == null) {
            return null;
        }
        ListNode mergedListHead = null;
        ListNode mergedList = null;
        while(list1 != null && list2 != null) {
            if(list2.val < list1.val) {
                if(mergedListHead == null) {
                    mergedList = mergedListHead = list2;
                } else {
                    mergedList = mergedList.next = list2;
                }
                list2 = list2.next;
            } else {
                if(mergedListHead == null) {
                    mergedList = mergedListHead = list1;
                } else {
                    mergedList = mergedList.next = list1;
                }
                list1 = list1.next;
            }
        }
        if(list1 != null) {
            if(mergedListHead == null) {
                return list1;
            }
            mergedList.next = list1;
        } else {
            if(mergedListHead == null) {
                return list2;
            }
            mergedList.next = list2;
        }
        return mergedListHead;
    }
}