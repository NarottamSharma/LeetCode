class Solution {
    public boolean isAnagram(String s, String t) {
        // EDGE CASE: Length Check
        // If strings are different lengths, they cannot possibly be anagrams.
        // This is a quick exit that saves time.
        if (s.length() != t.length()) {
            return false;
        }

        // FREQUENCY ARRAY (The Balance Sheet)
        // We use size 26 because the problem assumes lowercase English letters ('a' - 'z').
        // This acts as a hash map but is much faster (O(1) access time).
        int[] count = new int[26];

        // SINGLE PASS LOOP
        // We iterate through both strings simultaneously to balance the counts.
        for (int i = 0; i < s.length(); i++) {
            
            // Logic for String 's':
            // convert char to index (e.g., 'a' -> 0, 'b' -> 1).
            // INCREMENT (+) for every character found in 's'.
            count[s.charAt(i) - 'a']++;
            
            // Logic for String 't':
            // DECREMENT (-) for every character found in 't'.
            count[t.charAt(i) - 'a']--;
        }

        // FINAL VALIDATION
        // If s and t are anagrams, every increment from 's' should have been 
        // perfectly cancelled out by a decrement from 't'.
        // The array must be all zeros.
        for (int i = 0; i < 26; i++) {
            
            // If any index is NOT 0, the balance is off.
            // Positive value means 's' had extra.
            // Negative value means 't' had extra.
            if (count[i] != 0) {
                return false;
            }
        }

        // If we survive the loop, the strings are valid anagrams.
        return true;
    }
}