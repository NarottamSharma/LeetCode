class Solution {
    public int totalFruit(int[] fruits) {
        // Map to store {FruitType : Count}
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            // 1. Add fruit at 'right' to the basket
            int currentFruit = fruits[right];
            basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);

            // 2. If we have MORE than 2 types of fruit, we must shrink
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                
                // Decrease count of the fruit leaving the window
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                
                // If count becomes 0, remove it COMPLETELY from map
                // This reduces map.size() back to 2
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                
                left++; // Move start of window forward
            }

            // 3. Update max (Window is valid here)
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}