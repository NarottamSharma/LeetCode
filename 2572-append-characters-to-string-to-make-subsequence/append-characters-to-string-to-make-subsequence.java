class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0; // Pointer for s
        int j = 0; // Pointer for t
        
        int n = s.length();
        int m = t.length();

        // Iterate while both strings have characters left
        while (i < n && j < m) {
            // If characters match, we found a piece of the subsequence!
            if (s.charAt(i) == t.charAt(j)) {
                j++; // Move to the next target character
            }
            // Always move the source pointer forward
            i++;
        }

        // The number of characters remaining in t is the answer
        return m - j;
    }
}