class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // Use long for sum because 10^5 * 10^5 can exceed integer limit
        long currentSum = 0;
        long maxSum = 0;
        
        // Map to store frequency of elements in the CURRENT window
        // Key: Number, Value: Count
        Map<Integer, Integer> map = new HashMap<>();

        // 1. Build the first window (indices 0 to k-1)
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Check if the first window is valid (all elements distinct)
        if (map.size() == k) {
            maxSum = currentSum;
        }

        // 2. Slide the window
        for (int i = k; i < nums.length; i++) {
            int entering = nums[i];
            int leaving = nums[i - k];

            // A. Add the new element (Entering)
            currentSum += entering;
            map.put(entering, map.getOrDefault(entering, 0) + 1);

            // B. Remove the old element (Leaving)
            currentSum -= leaving;
            if (map.get(leaving) == 1) {
                map.remove(leaving); // Completely remove if count becomes 0
            } else {
                map.put(leaving, map.get(leaving) - 1);
            }

            // C. Check validity: If map size is k, all elements are unique
            if (map.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}