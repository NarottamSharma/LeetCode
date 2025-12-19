class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Use double for sum to handle large numbers and decimals later
        double currentSum = 0; 
        
        // 1. Build the first window sum
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum; // Initialize max with the first window
        
        // 2. Slide the window
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i];       // Add entering element
            currentSum -= nums[i - k];   // Remove leaving element
            
            // Update max sum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // 3. Convert max sum to average at the very end
        return maxSum / k;
    }
}