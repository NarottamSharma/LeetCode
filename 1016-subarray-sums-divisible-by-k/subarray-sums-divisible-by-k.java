class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        int currentSum=0;
        map.put(0,1);
        for(int num:nums){
            currentSum+=num;
            int rem = currentSum%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}