class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // Use a dynamic list because we don't know how many intersections we will find.
        List<int[]> res = new ArrayList<>();
        
        // Pointers: 'i' for the first list, 'j' for the second list.
        int i = 0, j = 0;
        
        // Loop until one list runs out. 
        // Logic: If one list is empty, no more intersections are possible.
        while(i < firstList.length && j < secondList.length) {
            
            // Extract coordinates for readability
            int s1 = firstList[i][0]; // Start of interval A
            int e1 = firstList[i][1]; // End of interval A
            int s2 = secondList[j][0]; // Start of interval B
            int e2 = secondList[j][1]; // End of interval B
            
            // 1. CHECK FOR OVERLAP
            // A common way to check if two intervals overlap:
            // "Start of A <= End of B" AND "Start of B <= End of A"
            // If this is true, they definitely touch or cross.
            if(e1 >= s2 && e2 >= s1) {
                
                // 2. CALCULATE INTERSECTION
                // The intersection is the TIGHTEST bounds:
                // Start = Max of the two starts (the later one)
                // End   = Min of the two ends (the earlier one)
                res.add(new int[]{
                    Math.max(s1, s2),
                    Math.min(e1, e2)
                });
            }
            
            // 3. MOVE POINTERS (The "Who Ends First" Logic)
            // We always discard the interval that finishes first.
            // Why? Because if it ends at time 'e1', it cannot possibly overlap 
            // with any future interval in the OTHER list that starts after 'e1'.
            if(e1 < e2) {
                i++; // List A's interval ends first, so move A forward
            } else {
                j++; // List B's interval ends first (or they end at same time), move B forward
            }
        }
        
        // Convert the ArrayList back to the required primitive 2D array format
        return res.toArray(new int[res.size()][]);
    }
}