class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;      // Last valid element in nums1
        int p2 = n - 1;      // Last element in nums2
        int p = m + n - 1;   // Last position in nums1 (where we write)

        // While there are elements to process in nums2
        while (p2 >= 0) {
            // If nums1 has elements left AND is larger than nums2
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // Otherwise, take from nums2
                nums1[p] = nums2[p2];
                p2--;
            }
            p--; // Move write pointer backward
        }
    }
}