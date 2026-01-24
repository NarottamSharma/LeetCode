import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // 1. Sort meetings by start time. 
        // This organizes the timeline so we can scan left-to-right.
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        //   [[5,7],[1,3],[9,10]]
        //   [[1,3],[5,7],[9,10]]
        //     s     e
        long freeDays = 0; // Use long just in case, though int fits in return type
        int lastBusyDay = 0; // Tracks the furthest day we are occupied

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // 2. Check for a gap BEFORE this meeting starts
            // If the current meeting starts strictly after the last busy day (+1),
            // then all days in between are free.
            if (start > lastBusyDay + 1) {
                freeDays += (start - lastBusyDay - 1);
            }

            // 3. Update the last busy day
            // We use Math.max because a previous meeting might have been 
            // longer than the current one (e.g., [1, 10] covers [2, 5])
            lastBusyDay = Math.max(lastBusyDay, end);
        }

        // 4. Check for a trailing gap AFTER the last meeting
        // If the last meeting ended on day 8 and total days is 10, we have 2 free days.
        if (lastBusyDay < days) {
            freeDays += (days - lastBusyDay);
        }

        return (int) freeDays;
    }
}