class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        // This Set stores characters currently in the window [left, right]
        Set<Character> window = new HashSet<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // If the character is ALREADY in the set, we have a duplicate!
            // We must SHRINK the window from the left until the duplicate is removed.
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Now the window is valid (duplicate is gone or never existed).
            // Add the new character.
            window.add(currentChar);
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
            
            // Move right pointer forward
            right++;
        }

        return maxLength;
    }
}