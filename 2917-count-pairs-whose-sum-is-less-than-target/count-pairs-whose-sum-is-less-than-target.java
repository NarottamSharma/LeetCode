import java.util.Collections;
import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // Step 1: Sort the list (O(n log n))
        Collections.sort(nums);
        
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;
        
        // Step 2: Two Pointer Scan (O(n))
        while (left < right) {
            // Check sum of the smallest and largest available numbers
            if (nums.get(left) + nums.get(right) < target) {
                // MAGIC: If (left + right) works, then (left + right-1), 
                // (left + right-2)... all work.
                // We count ALL these pairs at once.
                count += (right - left);
                
                // We are done with this 'left' element, try the next smallest
                left++;
            } else {
                // Sum is too big, we need a smaller number from the right
                right--;
            }
        }
        
        return count;
    }
}