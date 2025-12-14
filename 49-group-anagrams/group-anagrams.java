class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. Create the Frequency Array (The "Fingerprint")
            int[] hash = new int[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            
            // 2. Convert Array to a Unique String Key
            // Arrays.toString creates a string like "[1, 2, 0, ...]"
            String key = Arrays.toString(hash); 
            
            // 3. Group them in the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
