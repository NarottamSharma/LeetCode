import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Step 1: Sort the array (O(N log N))
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Skip duplicate 'i' values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // We need left + right == -i
            
            // Step 3: Standard Two Pointer approach
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    // Found a triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Step 4: Skip duplicate 'left' and 'right' values
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move pointers inward after processing duplicates
                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Sum too small
                } else {
                    right--; // Sum too big
                }
            }
        }
        return result;
    }
}