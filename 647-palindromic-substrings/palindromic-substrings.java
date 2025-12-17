class Solution {
    public int countSubstrings(String s) {
        int totalCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 1. Count Odd Palindromes (Center is i)
            totalCount += countPalindromes(s, i, i);
            
            // 2. Count Even Palindromes (Center is between i and i+1)
            totalCount += countPalindromes(s, i, i + 1);
        }
        
        return totalCount;
    }
    
    // HELPER METHOD:
    // Expands from the center and returns HOW MANY palindromes it found.
    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        
        // As long as we are in bounds and characters match...
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;    // We found a valid palindrome! Count it.
            left--;     // Expand Left
            right++;    // Expand Right
        }
        
        return count;
    }
}