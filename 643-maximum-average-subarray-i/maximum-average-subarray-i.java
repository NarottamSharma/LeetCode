class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // 1. Calculate sum of the first window (indices 0 to k-1)
        double currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        // Initialize max sum with the first window's sum
        double maxSum = currentSum;

        // 2. Slide the window from index k to the end
        for (int i = k; i < nums.length; i++) {
            // Add the new element (right)
            currentSum += nums[i];
            
            // Remove the old element (left)
            // The element leaving is at index (i - k)
            currentSum -= nums[i - k];

            // Update max sum
            maxSum = Math.max(maxSum, currentSum);
        }

        // 3. Convert sum to average (divide only once!)
        return maxSum / k;
    }
}