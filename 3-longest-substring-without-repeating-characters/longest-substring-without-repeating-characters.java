class Solution {
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
}