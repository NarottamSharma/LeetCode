class Solution {
    public int characterReplacement(String s, int k) {

        // counts[x] = frequency of character (x) inside the current window [i..j]
        // since string has only 'A' to 'Z', size = 26
        int counts[] = new int[26];

        // maxC = maximum frequency of any single character in the current window
        // (example: window = "AAB", maxC = 2 because 'A' appears 2 times)
        int maxC = 0;

        // max = final answer (maximum valid window length found so far)
        int max = 0;

        // i = left pointer of the sliding window
        int i = 0;

        // j = right pointer of the sliding window (we expand it step by step)
        for (int j = 0; j < s.length(); j++) {

            // Step 1: include s[j] into the window
            char c = s.charAt(j);

            // increase frequency of this character inside the window
            counts[c - 'A']++;

            // Step 2: update maxC
            // maxC tells us: "what is the most frequent character count in this window?"
            // we track it because it helps decide how many replacements are needed
            maxC = Math.max(counts[c - 'A'], maxC);

            // Step 3: check if the window is valid or not
            // Window size = (j - i + 1)
            // If maxC is the count of the most frequent char,
            // then all other characters = windowSize - maxC
            //
            // Those "other characters" are the ones we must replace
            // to make the whole window become the same character.
            //
            // Condition:
            // if (windowSize - maxC) > k  => too many replacements needed => invalid window
            while ((j - i + 1) - maxC > k) {

                // Step 4: window is invalid, so shrink it from the left
                char left = s.charAt(i);

                // remove s[i] from the window count
                counts[left - 'A']--;

                // move left pointer forward
                i++;
            }

            // Step 5: now window is valid again
            // update the best (maximum) window length
            max = Math.max(max, j - i + 1);
        }

        // Step 6: return the largest valid window length found
        return max;
    }
}
