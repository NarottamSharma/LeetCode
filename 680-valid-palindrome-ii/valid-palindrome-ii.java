class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Match found, continue shrinking the window
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } 
            // Mismatch found! This is our "One Strike".
            else {
                // Try deleting left char OR deleting right char
                // If either results in a palindrome, we win.
                return check(s, left + 1, right) || check(s, left, right - 1);
            }
        }
        
        return true; // No mismatches ever found
    }

    // Standard palindrome checker for a substring range
    private boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}