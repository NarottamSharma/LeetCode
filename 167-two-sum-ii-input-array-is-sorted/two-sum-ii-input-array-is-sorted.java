class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            
            if (sum == target) {
                // Return the 0-based indices
                return new int[]{i+1, j+1}; 
                
                // Note: Some platforms (like LeetCode) ask for 1-based indices.
                // In that case, you would return: new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        
        // Return an empty array if no solution is found.
        return new int[0]; 
    }
}