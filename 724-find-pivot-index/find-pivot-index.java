class Solution {
    public int pivotIndex(int[] nums) {
        // 1. Calculate the Total Sum of the entire array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 2. Initialize leftSum
        int leftSum = 0;

        // 3. Iterate through the array to find the pivot
        for (int i = 0; i < nums.length; i++) {
            // We calculate rightSum on the fly using the formula
            int rightSum = totalSum - leftSum - nums[i];

            // 4. Check if we found the pivot
            if (leftSum == rightSum) {
                return i; // Found it! Return the index immediately
            }

            // 5. If not, add the current number to leftSum for the next iteration
            leftSum += nums[i];
        }

        // 6. If we finish the loop without returning, no pivot exists
        return -1;
    }
}