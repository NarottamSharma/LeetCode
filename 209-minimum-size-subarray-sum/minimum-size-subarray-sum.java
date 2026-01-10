class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE; // Start with largest possible value

        // 1. Expand the window with 'right'
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // 2. Shrink the window as long as condition is met
            while (currentSum >= target) {
                // We found a valid window! Check if it's the smallest so far.
                int currentWindowSize = right - left + 1;
                minLength = Math.min(minLength, currentWindowSize);

                // Remove left element to try and make it smaller
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength never changed, it means no valid subarray exists
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}