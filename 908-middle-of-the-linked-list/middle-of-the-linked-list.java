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
    public ListNode middleNode(ListNode head) {
        // 1. Initialize both pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        // 2. Loop condition is key:
        // fast != null      -> Handles even length lists (fast lands on null)
        // fast.next != null -> Handles odd length lists (fast lands on last node)
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move 1 step
            fast = fast.next.next;  // Move 2 steps
        }

        // 3. Slow is now at the middle
        return slow;
    }
}