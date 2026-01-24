import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // PHASE 1: Left Zone (Strictly before)
        // Add intervals that end before the new one starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // PHASE 2: Merge Zone (The Snowball)
        // While intervals start before the new one ends, they overlap.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Expand the snowball
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the fully grown snowball
        result.add(newInterval);

        // PHASE 3: Right Zone (Strictly after)
        // Just copy the rest. (This will copy [12,16] and [14,18] as is)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}