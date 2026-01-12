class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashSet acts as our sliding window
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 1. Check if the current number exists in the window
            if (window.contains(nums[i])) {
                return true; 
            }

            // 2. Add current number to the window
            window.add(nums[i]);

            // 3. Slide the window: maintain size <= k
            // If we have more than k elements, remove the oldest one (from the left)
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}