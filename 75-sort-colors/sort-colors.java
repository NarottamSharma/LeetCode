class Solution {
    public void sortColors(int[] nums) {
        // low:  Points to where the next 0 should go.
        // mid:  The current element we are inspecting.
        // high: Points to where the next 2 should go.
        int low = 0, mid = 0, high = nums.length - 1;

        // Iterate until the 'mid' pointer crosses the 'high' pointer.
        // This means we have processed all unsorted elements.
        while (mid <= high) {
            
            // CASE 1: Found a 0 (Red)
            if (nums[mid] == 0) {
                // Swap current element with the 'low' boundary.
                // This moves the 0 into the correct [0...low] zone.
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                
                // Expand the 0-zone.
                low++;
                
                // Advance mid. We know the element swapped from 'low' was definitely 
                // a 1 (or the pointer was equal), so it's safe to move past it.
                mid++; 
            } 
            
            // CASE 2: Found a 1 (White)
            else if (nums[mid] == 1) {
                // It is already in the correct relative position (middle).
                // Just move past it to check the next number.
                mid++;
            } 
            
            // CASE 3: Found a 2 (Blue)
            else { 
                // Swap current element with the 'high' boundary.
                // This moves the 2 into the correct [high...end] zone.
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                
                // Shrink the unsorted zone from the right.
                high--;
                
                // CRITICAL: Do NOT increment mid.
                // The value we just swapped IN from 'high' is unknown (could be 0, 1, or 2).
                // We must re-examine nums[mid] in the next iteration.
            }
        }
    }   
}