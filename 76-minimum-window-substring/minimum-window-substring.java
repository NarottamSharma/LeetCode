class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 1. Create the Frequency Map (The "Bill")
        int[] map = new int[128]; 
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        
        // 'count' represents how many characters required by T are currently in the window
        // Actually, it's easier to count how many we *still need* or track total matches.
        // Let's track "total characters needed".
        int count = t.length();

        char[] sChars = s.toCharArray(); // Faster access than s.charAt()

        while (right < s.length()) {
            // --- EXPAND Phase ---
            char rChar = sChars[right];
            
            // If map[rChar] > 0, it means this char is part of T and we still need it.
            // So we reduce the global 'count' of needed chars.
            if (map[rChar] > 0) {
                count--;
            }
            
            // We decrement the map value regardless. 
            // If it goes negative, it means we have "extra" of this char.
            map[rChar]--;
            right++;

            // --- SHRINK Phase ---
            // When count == 0, our window is valid (contains all of T)
            while (count == 0) {
                
                // 1. Update our best answer found so far
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                // 2. Try to shrink from the left
                char lChar = sChars[left];
                
                // We are removing lChar from the window, so we add it back to the map/bill.
                map[lChar]++;
                
                // If map[lChar] becomes > 0, it means we just removed a character 
                // that was *required* to satisfy T. The window is no longer valid.
                if (map[lChar] > 0) {
                    count++;
                }
                
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}