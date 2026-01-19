class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Map stores <Remainder, Frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: A remainder of 0 exists before the array starts
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Calculate Remainder
            int rem = currentSum % k;
            
            // JAVA TRICK: Handle negative remainders!
            // If rem is -2 and k is 5, we want the remainder to be 3.
            if (rem < 0) {
                rem += k;
            }
            
            // If we have seen this remainder before, it means the 
            // chunk between that previous point and now is divisible by k.
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            
            // Store the current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        return count;
    }
}