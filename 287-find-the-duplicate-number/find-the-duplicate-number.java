class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect the cycle (Find intersection)
        // We start effectively at the "head" (index 0)
        int slow = nums[0];
        int fast = nums[nums[0]];
        
        while (slow != fast) {
            slow = nums[slow];           // Move 1 step
            fast = nums[nums[fast]];     // Move 2 steps
        }
        
        // Phase 2: Find the entrance to the cycle (The Duplicate)
        slow = 0; // Reset slow to the start (Index 0)
        
        while (slow != fast) {
            slow = nums[slow];           // Move 1 step
            fast = nums[fast];           // Move 1 step
        }
        
        return slow; // The meeting point is the duplicate value
    }
}