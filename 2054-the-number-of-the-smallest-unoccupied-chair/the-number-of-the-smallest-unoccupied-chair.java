class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        // sort times by start time
        // we need n chair
        // linear data structure , stores end time of chair
        // 0 end times chairs initially 
        // all chairs are available initially
        // Arrays.sort(times,(a,b)->a[0]-b[0]); 
        int targetFriendArrivalTime = times[targetFriend][0];
        Arrays.sort(times,(a,b)->Integer.compare(a[0], b[0]));   
        int[] chairs = new int[times.length];
        for(int i=0;i<times.length;i++){
            // processing current friend
            for(int j=0;j<chairs.length;j++){
                if(times[i][0]>=chairs[j]){
                    if(targetFriendArrivalTime == times[i][0]){
                        return j;
                    }
                    chairs[j] = times[i][1];
                    break;
                }
            }
        } 
        return -1;

    }
}