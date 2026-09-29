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
head - already
map - index, node (int, ListNode)
time - O(n)
space - O(n)




 */

class Solution {
    public void reorderList(ListNode head) {
        Map<Integer,ListNode> indexListNodeMap = new HashMap<>();
        ListNode temp = head;
        int i=0;
        while(temp!=null) {
            indexListNodeMap.put(i++, temp);
            temp = temp.next;
        }
        int j=1,k=i-1;
        temp = head;
        for(; j<=k; j++,k--) {
            ListNode left = indexListNodeMap.get(j);
            ListNode right = indexListNodeMap.get(k);
            temp.next = right;
            temp = temp.next;
            if(j!=k) {
                temp.next = left;
                temp = temp.next;
            }
        }
        temp.next = null;
    }
}
