class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int answer1 = fib(n-2);
        int answer2 = fib(n-1);
        return answer1+answer2;
    }
}