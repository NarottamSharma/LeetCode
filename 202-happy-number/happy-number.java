class Solution {
    public boolean isHappy(int n) {
        int slow = n; 
        
        // 1. JUMP START: Calculate the first step for 'fast' immediately.
        // This ensures 'slow' and 'fast' are different before the loop starts.
        int fast = getSumOfSquare(n); 

        // 2. LOOP CONDITION: Run as long as:
        //    a) 'fast' has not reached the happy target (1).
        //    b) We have not detected a cycle (slow == fast).
        while (fast != 1 && slow != fast) {
            
            // 3. Move Slow: 1 step at a time
            slow = getSumOfSquare(slow);
            
            // 4. Move Fast: 2 steps at a time
            // We call the function twice to simulate speed x2
            fast = getSumOfSquare(getSumOfSquare(fast));
        }

        // 5. CHECK RESULT:
        // The loop broke because either fast hit 1 (Happy) or fast hit slow (Cycle/Unhappy).
        return fast == 1;
    }
    
    public int getSumOfSquare(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}