class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSumOfSquare(n); // Move fast ahead immediately

        // Standard while loop now works because slow != fast initially
        while (fast != 1 && slow != fast) {
            slow = getSumOfSquare(slow);
            fast = getSumOfSquare(getSumOfSquare(fast));
        }

        // Check fast (or slow, if they met)
        return fast == 1;
    }
    public int getSumOfSquare(int num) {     // Unchanged

        int sum = 0;

        while (num > 0) {

            int digit = num % 10;

            sum += digit * digit;

            num /= 10;

        }

        return sum;

    }
}
