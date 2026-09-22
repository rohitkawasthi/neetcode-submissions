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
        //terminal condition
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode temp = new ListNode();
        ListNode reverseList = null;

        //subproblem
        if(list1.val <= list2.val) {
            reverseList = mergeTwoLists(list1.next, list2);
            temp.next = list1;
        } else {
            reverseList = mergeTwoLists(list1, list2.next);
            temp.next = list2;
        }

        temp.next.next = reverseList;
        
        return temp.next;
   }
}