class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    if (s.length() < 10) {
        return new ArrayList<>();
    }
    Set<String> seen = new HashSet<>();  // renamed for clarity
    Set<String> repeated = new HashSet<>();
    for (int i = 0; i + 10 <= s.length(); i++) {
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