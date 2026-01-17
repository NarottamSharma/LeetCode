class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge check: If empty or only 1 interval, nothing to merge
        if (intervals.length <= 1) return intervals;

        // 1. Sort by Start Time (Crucial Step!)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        
        // 2. Start with the first interval
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        // 3. Iterate through the rest
        for (int[] nextInterval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];

            if (nextStart <= currentEnd) { 
                // OVERLAP: Update the end time to the max of both
                // We modify the interval currently inside the list directly
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // NO OVERLAP: Move to the next interval
                currentInterval = nextInterval;
                result.add(currentInterval);
            }
        }

        // Convert List to Array
        return result.toArray(new int[result.size()][]);
    }
}