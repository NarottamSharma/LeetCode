class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];

        for(int i=0;i<s.length();i++){
            int digit = s.charAt(i)-'0';
            digits[i] = digit;
            if(digit%2==0){
                even.offer(digit);
            } else{
                odd.add(digit);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int digit:digits){
            if(digit%2==0){
                res.append(even.poll());
            } else{
                res.append(odd.poll());
            }
        }

        return Integer.parseInt(res.toString());

    }
}