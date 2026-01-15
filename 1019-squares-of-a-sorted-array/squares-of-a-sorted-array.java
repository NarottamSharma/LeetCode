class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;              // Length of input array

        int right = n - 1;                // Right pointer at the last index
        int left = 0;                     // Left pointer at the first index
        int pos = n - 1;                  // Position to fill in result from the end

        int[] res = new int[n];           // Result array to store sorted squares

        // Loop until the two pointers cross
        while (left <= right) {

            // Square of the element at the right pointer
            int rightSq = nums[right] * nums[right];

            // Square of the element at the left pointer
            int leftSq = nums[left] * nums[left];

            // The larger square should go at the current 'pos' index
            if (rightSq < leftSq) {
                res[pos] = leftSq;        // Place left square at current position
                pos--;                    // Move position backward
                left++;                   // Move left pointer to the right
            } else {
                res[pos] = rightSq;       // Place right square at current position
                pos--;                    // Move position backward
                right--;                  // Move right pointer to the left
            }
        }

        // At this point, 'res' contains all squares in non-decreasing order
        return res;
    }
}
