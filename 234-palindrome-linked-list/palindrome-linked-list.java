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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int i=0, j=list.size()-1;
        while(i<=j){
            if(list.get(i)!=list.get(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    
    }
}

/**
public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // STEP 1: Find the Middle (Slow/Fast Pointers)
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps
        }
        // 'slow' is now at the middle.

        // STEP 2: Reverse the Second Half
        ListNode secondHalfStart = reverseList(slow);
        ListNode firstHalfStart = head;

        // STEP 3: Compare Both Halves
        ListNode p1 = firstHalfStart;
        ListNode p2 = secondHalfStart;
        
        // Loop until the second half reaches the end (null)
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false; // Mismatch found
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Standard Helper Method to Reverse a Linked List
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse arrow
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }
        return prev; // 'prev' is the new head of the reversed list
    }
}
 */