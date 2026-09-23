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
    private Set<ListNode> visited = new HashSet<>();

    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        if(!visited.add(head)) {
            return true;
        }
        return hasCycle(head.next);
    }
}
