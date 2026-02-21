import java.util.Arrays;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // 1. CHRONOLOGICAL ORDER: 
        // We must process meetings in the order they start.
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. STATE TRACKERS:
        // endTimesOfRooms[i] stores the exact time room 'i' will become free.
        // Using 'long' is crucial here because delayed meetings can push end times beyond the 32-bit int limit.
        long[] endTimesOfRooms = new long[n];
        
        // counts[i] keeps the score of how many meetings room 'i' has hosted.
        int[] counts = new int[n]; 
        
        // 3. PROCESS EACH MEETING:
        for(int i = 0; i < meetings.length; i++){
            int startTime = meetings[i][0];
            int endTimes = meetings[i][1]; // The original scheduled end time of this specific meeting

            boolean isRoomAllocated = false;
            
            // This will remember the room that frees up the earliest, just in case ALL rooms are currently full.
            int minEndTimeRoomIdx = 0; 
            
            // 4. SCAN ALL ROOMS (0 to n-1):
            // Scanning from 0 upwards naturally handles the rule: "choose the room with the lowest ID".
            for(int room = 0; room < n; room++){
                
                // SCENARIO A: We found an available room!
                // If the meeting starts after or exactly when the room frees up:
                if(startTime >= endTimesOfRooms[room]){
                    // Update the room's calendar to this meeting's end time.
                    endTimesOfRooms[room] = endTimes;
                    counts[room]++; // Give the room a point
                    isRoomAllocated = true; // Mark as successfully scheduled
                    
                    // Break immediately! Since we loop from 0 to n-1, the first free room 
                    // we find is GUARANTEED to have the lowest possible ID.
                    break; 
                }
                
                // SCENARIO B: Room is occupied. 
                // We keep track of which room will free up the earliest.
                // Notice the strictly less than '<'. If two rooms free up at the exact same time,
                // this ensures we keep the smaller room ID we found earlier.
                if(endTimesOfRooms[room] < endTimesOfRooms[minEndTimeRoomIdx]){
                    minEndTimeRoomIdx = room;
                }
            }

            // 5. HANDLE DELAYS:
            // If the loop finished and we never hit the 'break' statement, ALL rooms were busy.
            if(!isRoomAllocated){
                // We are forced to use the room that frees up earliest (minEndTimeRoomIdx).
                // The new end time is the time the room becomes free PLUS the duration of the meeting.
                // Duration = (original end time - original start time).
                endTimesOfRooms[minEndTimeRoomIdx] += (endTimes - startTime);
                
                // Give the room a point since it's hosting this delayed meeting.
                counts[minEndTimeRoomIdx]++;
            }
        }
        
        // 6. FIND THE WINNER:
        int maxRoomCountsIdx = 0;
        for(int i = 0; i < n; i++){
            // Scan the scoreboard. 
            // Again, using strictly greater than '>' means if Room 0 and Room 2 both have 5 meetings,
            // we ignore Room 2 and keep maxRoomCountsIdx as 0 (handling the final tie-breaker).
            if(counts[i] > counts[maxRoomCountsIdx]){
                maxRoomCountsIdx = i;
            }
        }
        
        return maxRoomCountsIdx;
    }
}