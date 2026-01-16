class Solution {
    public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>(); // Stores char -> index
    int i = 0; // Left pointer
    int max = 0;

    for (int j = 0; j < s.length(); j++) { // j is Right pointer
        char c = s.charAt(j);
        
        // If we have seen this char AND it is inside the current window
        if (map.containsKey(c) && map.get(c) >= i) {
            // Jump left pointer to right after the previous instance
            i = map.get(c) + 1;
        }
        
        map.put(c, j); // Update latest index of char
        max = Math.max(max, j - i + 1);
    }
    return max;
}

    /*
     public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        int right = 0;
        int maxLength = 0;
        
        // Loop until the right pointer reaches the end
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            
            // CASE 1: Character is NEW (Valid Window)
            if (!set.contains(currentChar)) {
                set.add(currentChar);       // Add to window
                maxLength = Math.max(maxLength, set.size()); // Update record
                right++;                    // Expand right
            } 
            // CASE 2: Character is a DUPLICATE (Invalid Window)
            else {
                // Remove the oldest character from the left to resolve conflict
                set.remove(s.charAt(left)); 
                left++;                     // Shrink left
                
                // Note: We do NOT move 'right' yet. 
                // We stay on the same char and loop again to see if the duplicate is gone.
            }
        }
        
        return maxLength;
    }
     */
}