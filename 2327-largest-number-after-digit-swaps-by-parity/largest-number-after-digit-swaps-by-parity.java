import java.util.*;

class Solution {
    public int largestInteger(int num) {
        // 1. Setup two Max-Heaps
        PriorityQueue<Integer> evens = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odds = new PriorityQueue<>(Collections.reverseOrder());
        
        // Convert number to string to easily iterate digits
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        
        // 2. Populate Heaps
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            digits[i] = digit; // Store original digit to remember parity later
            if (digit % 2 == 0) {
                evens.add(digit);
            } else {
                odds.add(digit);
            }
        }
        
        // 3. Rebuild the number
        StringBuilder res = new StringBuilder();
        for (int digit : digits) {
            // Check the parity of the ORIGINAL digit at this position
            if (digit % 2 == 0) {
                res.append(evens.poll()); // Pick largest available Even
            } else {
                res.append(odds.poll());  // Pick largest available Odd
            }
        }
        
        return Integer.parseInt(res.toString());
    }
}