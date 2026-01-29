/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Create a dummy node to handle edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // Step 2: Move 'fast' pointer n + 1 steps ahead
        // Why n+1? Because we want 'slow' to stop right BEFORE the target node.
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Step 3: Move both pointers until 'fast' reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Step 4: Skip the target node
        // 'slow' is currently pointing to the node before the target.
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}