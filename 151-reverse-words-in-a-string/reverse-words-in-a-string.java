class Solution {
    public String reverseWords(String s) {
        // 1. Convert to char array for easier access (optional but fast)
        // Or just use s.charAt(i)
        
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = n - 1;

        while (i >= 0) {
            // A. Skip trailing/intermediate spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            
            // If we went past the start, we are done
            if (i < 0) break;

            // B. Mark the END of the word
            int end = i;

            // C. Find the START of the word
            // Keep moving left until we hit a space or start of string
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            
            // D. Extract the word
            // substring is (start, end + 1) because end is inclusive
            String word = s.substring(i + 1, end + 1);
            
            // E. Add to result
            if (result.length() > 0) {
                result.append(" "); // Add separator if it's not the first word found
            }
            result.append(word);
        }

        return result.toString();
    }
}