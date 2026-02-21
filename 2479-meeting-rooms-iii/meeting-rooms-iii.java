class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->Integer.compare(a[0],b[0]));

        long[] endTimesOfRooms =  new long[n];
        int[] counts = new int[n]; 
        for(int i=0;i<meetings.length;i++){
            int startTime = meetings[i][0];
            int endTimes = meetings[i][1];

            boolean isRoomAllocated = false;

            int minEndTimeRoomIdx=0;
            for(int room=0;room<n;room++){
                if(startTime>=endTimesOfRooms[room]){
                    endTimesOfRooms[room] = endTimes;
                    counts[room]++;
                    isRoomAllocated = true;
                    break;
                }
                if(endTimesOfRooms[room] < endTimesOfRooms[minEndTimeRoomIdx]){
                    minEndTimeRoomIdx = room;
                }
            }

            if(!isRoomAllocated){
                endTimesOfRooms[minEndTimeRoomIdx]+=endTimes-startTime;
                counts[minEndTimeRoomIdx]++;
            }

        }
        int maxRoomCountsIdx = 0;
        for(int i=0;i<n;i++){
            if(counts[i]>counts[maxRoomCountsIdx]){
                maxRoomCountsIdx = i;
            }
        }
        return maxRoomCountsIdx;

    }
}