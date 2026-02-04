class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        while (list.size() > 1) {
            Collections.sort(list, Collections.reverseOrder());  // Sort descending for easier access
            int stone1 = list.remove(0);  // Heaviest
            int stone2 = list.remove(0);  // Next heaviest
            int addStone = stone1 - stone2;
            if (addStone > 0) {  // Only add if difference > 0
                list.add(addStone);
            }
        }
        return list.isEmpty() ? 0 : list.get(0);
    }
}
