class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store <PrefixSum, Frequency>
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // IMPORTANT: Initialize with sum 0 having count 1
        // This covers the case where a subarray starts from index 0
        map.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            // 1. Add current number to the running sum
            currentSum += num;
            
            // 2. Calculate what 'past sum' we are looking for
            // Formula: currentSum - oldSum = k  =>  oldSum = currentSum - k
            int neededSum = currentSum - k;
            
            // 3. If that past sum exists, add its frequency to our count
            if (map.containsKey(neededSum)) {
                count += map.get(neededSum);
            }
            
            // 4. Add the current sum to the map for future checks
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    /**
    Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        int currentSum=0;
        for( int num:nums){
            currentSum+=num;
            int neededSum = currentSum-k;
            if(map.containsKey(neededSum)){
                count+=map.get(neededSum);
            }
            map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        }
        return count;
     */

}