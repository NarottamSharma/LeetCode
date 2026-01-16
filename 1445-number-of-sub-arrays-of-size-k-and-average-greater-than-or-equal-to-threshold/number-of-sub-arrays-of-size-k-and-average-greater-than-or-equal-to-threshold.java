class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currentSum = 0;
        // Use logic: Sum >= k * threshold to avoid division/decimals
        int targetSum = k * threshold; 

        // 1. Build the first window (indices 0 to k-1)
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        // Check the first window
        if (currentSum >= targetSum) {
            count++;
        }

        // 2. Slide the window
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i];       // Add entering element
            currentSum -= arr[i - k];   // Remove leaving element
            
            // Check condition
            if (currentSum >= targetSum) {
                count++;
            }
        }

        return count;
    }
}