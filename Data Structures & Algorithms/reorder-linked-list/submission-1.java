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

[]  [2,4,6,8] , start

[2] ([4,6,8], end)
return [4,8,6,2]

[4] ([6,8], start)
return [4,8,6]

[6] ([8], end)
return [8,6]

return [8]

[1,2,3,4,5,6,7], start

[1] ([2...7], end)

[2] ([3...7], start)
return [2,4,3,7,5,6] 

[3] ([4...7], end)
return [3,4,7,5,6] 

[4] ([5...7], start)
retun [4,7,5,6]

[5] ([6...7], end)
retun [5,7,6]

[6] ([7], start)
retun [7,6]

[7] start
return [7]


[1] [2,7,3,6,4,5]
[1,7,2,6,3,5,4]


[1,2,3,4] [5,6,7]
[1,2] [3,4]


 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
       
        //reverse the next half
        ListNode prev = null;
        ListNode curr = mid.next;
        ListNode temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        mid.next = null;
        
        //now reorder
        ListNode forward = head;
        ListNode backward = prev;
        while(forward != null) {
            temp = forward.next;
            forward.next = backward;
            forward = temp;
            if(backward == null) {
                break;
            }
            temp = backward.next;
            backward.next = forward;
            backward = temp;
        }
    }
}
