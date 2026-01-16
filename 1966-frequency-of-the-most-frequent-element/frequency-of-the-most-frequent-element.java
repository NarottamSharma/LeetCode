class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 1. Sort the array so numbers close to each other are neighbors
        Arrays.sort(nums);
        
        int left = 0;
        long currentSum = 0; // Use long! Sum can exceed Integer.MAX_VALUE
        int maxFreq = 0;

        // 2. Expand window with right pointer
        for (int right = 0; right < nums.length; right++) {
            long target = nums[right];
            currentSum += target;

            // 3. Shrink window if operations cost > k
            // Cost = (Target * WindowSize) - Sum of numbers we actually have
            while ((target * (right - left + 1)) - currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            // 4. Update max frequency (Current window is valid)
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}