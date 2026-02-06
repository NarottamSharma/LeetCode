class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        
        // 1. Sort the times array directly (or a copy) by Arrival Time
        // We don't need to add an index column anymore.
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 2. Heaps
        // Occupied: {leaveTime, chairIndex}
        PriorityQueue<int[]> occupied = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Available: {chairIndex}
        PriorityQueue<Integer> available = new PriorityQueue<>();
        
        int nextNewChair = 0;
        
        // 3. Traditional For Loop
        int n = times.length;
        for (int i = 0; i < n; i++) {
            int arrival = times[i][0];
            int leaving = times[i][1];
            
            // Step A: Release chairs (Same logic)
            while (!occupied.isEmpty() && occupied.peek()[0] <= arrival) {
                available.add(occupied.poll()[1]);
            }
            
            // Step B: Assign chair (Same logic)
            int currentChair;
            if (available.isEmpty()) {
                currentChair = nextNewChair++;
            } else {
                currentChair = available.poll();
            }
            
            // Step C: OPTIMIZED CHECK
            // We identify the target solely by their unique arrival time
            if (arrival == targetArrival) {
                return currentChair;
            }
            
            // Step D: Record occupancy
            occupied.add(new int[]{leaving, currentChair});
        }
        
        return -1;

    }
}

/**

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

 */