class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        // We fill the result array from right to left (largest to smallest)
        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++; // We used the left number, so move left pointer forward
            } else {
                result[i] = rightSquare;
                right--; // We used the right number, so move right pointer backward
            }
        }
        
        return result;
    }
}