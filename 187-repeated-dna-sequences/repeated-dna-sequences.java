class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> seen = new HashSet<>(); // renamed for clarity
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (seen.contains(sub)) {
                repeated.add(sub);
            } else {
                seen.add(sub);
            }
        }
        return new ArrayList<>(repeated);
    }

}

/*
public List<String> findRepeatedDnaSequences(String s) {
        // Use a Set to store sequences we have seen so far
        Set<String> seen = new HashSet<>();
        
        // Use a Set for the result to avoid duplicates in the output
        Set<String> repeated = new HashSet<>();

        // Loop until there are 10 characters left
        // i goes from 0 to s.length() - 10
        for (int i = 0; i <= s.length() - 10; i++) {
            // Get the current window of size 10
            String substring = s.substring(i, i + 10);

            // Try adding to 'seen'. 
            // set.add() returns false if the element was ALREADY present.
            if (!seen.add(substring)) {
                repeated.add(substring);
            }
        }

        // Convert the result Set to a List
        return new ArrayList<>(repeated);
    }
 */