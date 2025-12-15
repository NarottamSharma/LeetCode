class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (center is i)
            // e.g., "aba" -> center 'b'
            int len1 = expandAroundCenter(s, i, i);
            
            // Case 2: Even length palindrome (center is between i and i+1)
            // e.g., "abba" -> center between 'b' and 'b'
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Which one was bigger?
            int len = Math.max(len1, len2);
            
            // If we found a new longest palindrome, update our global trackers
            // Logic to calculate new start/end based on length:
            if (len > end - start) {
                // Example: i=2, len=3 ("bab"). start = 2 - (2)/1 = 1.
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        // Return the substring (end + 1 because Java substring is exclusive)
        return s.substring(start, end + 1);
    }
    
    // HELPER METHOD: The "Spreading Wings" logic
    // Returns the length of the palindrome found
    private int expandAroundCenter(String s, int left, int right) {
        // While within bounds AND characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;  // Move left pointer further left
            right++; // Move right pointer further right
        }
        
        // Return length. 
        // Note: pointers are currently at INVALID positions (mismatch or out of bounds),
        // so the formula is (right - 1) - (left + 1) + 1 = right - left - 1.
        return right - left - 1;
    }
}