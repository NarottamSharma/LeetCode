import java.util.*;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max-Heap storing pairs of {count, character}
        // We use a simple custom class or int array. int[] is easier for interviews.
        // int[] format: {count, char_code}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        
        if (a > 0) maxHeap.add(new int[]{a, 'a'});
        if (b > 0) maxHeap.add(new int[]{b, 'b'});
        if (c > 0) maxHeap.add(new int[]{c, 'c'});
        
        StringBuilder sb = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            
            // Check for conflict: Does adding this char create a triple?
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == first[1] && sb.charAt(len - 2) == first[1]) {
                
                // We are blocked! We need a savior (the second best option)
                if (maxHeap.isEmpty()) {
                    break; // No separators left. We are done.
                }
                
                int[] second = maxHeap.poll();
                
                // Add the separator
                sb.append((char) second[1]);
                second[0]--;
                
                // Put second back if it still has count
                if (second[0] > 0) maxHeap.add(second);
                
                // Don't forget to put First back! We didn't use it yet.
                maxHeap.add(first);
                
            } else {
                // No conflict, safe to add First
                sb.append((char) first[1]);
                first[0]--;
                
                // Put First back if valid
                if (first[0] > 0) maxHeap.add(first);
            }
        }
        
        return sb.toString();
    }
}