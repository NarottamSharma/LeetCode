class Solution {
    public int[] runningSum(int[] nums) {
        // Start from 1 because the running sum at index 0 is just nums[0]
        for (int i = 1; i < nums.length; i++) {
            // Add the current value to the sum of all previous values
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
