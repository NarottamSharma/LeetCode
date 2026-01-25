/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected!
                // Phase 2: Find the entry point
                
                slow = head; // Reset slow to head
                
                while (slow != fast) {
                    // Move both at the SAME speed (1 step)
                    slow = slow.next;
                    fast = fast.next;
                }
                
                // They met at the cycle start
                return slow; 
            }
        }

        // No cycle found
        return null;
    }
}

/**
public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode node = head;
        while(node != null){
            if(seen.contains(node)) return node;
            seen.add(node);
            node = node.next;
        }
        return null;
    }
}
 */