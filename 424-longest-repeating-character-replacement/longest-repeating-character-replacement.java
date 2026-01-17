class Solution {
    public int characterReplacement(String s, int k) {
        // Frequency array for uppercase English letters (A-Z)
        int[] count = new int[26];
        
        int left = 0;
        int maxCount = 0; // Frequency of the most common char in the current window
        int maxLength = 0;
        
        // 'right' pointer expands the window
        for (int right = 0; right < s.length(); right++) {
            
            // 1. Add current character to count
            // s.charAt(right) - 'A' converts 'A'->0, 'B'->1, etc.
            int currentCharIndex = s.charAt(right) - 'A';
            count[currentCharIndex]++;
            
            // 2. Update the max frequency found so far in this window
            maxCount = Math.max(maxCount, count[currentCharIndex]);
            
            // 3. Validity Check: Window Length - Max Frequency > k
            // If true, the window is invalid (needs too many replacements)
            int windowLength = right - left + 1;
            if (windowLength - maxCount > k) {
                // Shrink the window from the left
                int leftCharIndex = s.charAt(left) - 'A';
                count[leftCharIndex]--;
                left++; 
            }
            
            // 4. Update the global maximum length
            // Note: We recalculate window length because left might have moved
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}