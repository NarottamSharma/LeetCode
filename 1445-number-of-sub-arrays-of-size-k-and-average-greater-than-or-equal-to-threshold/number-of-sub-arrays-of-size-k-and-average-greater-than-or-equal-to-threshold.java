class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int maxT = k*threshold; // sum/k >=threshold
        int sum=0;
        int count =0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum>=maxT){
            count++;
        }
        for(int i=k;i<arr.length;i++){
            sum+=arr[i];
            sum-=arr[i-k]; // remove
            if(sum>=maxT){
                count++;
            }
        }
        return count;
    }
}