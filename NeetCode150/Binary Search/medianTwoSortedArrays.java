public class medianTwoSortedArrays {
    /*
     * This leetcode problem involves finding the median of two sorted arrays.
     * The median is the middle value in a sorted array. If the array has an even number of elements, the median is the average of the two middle numbers.
     * If it is odd, its the middle number.
     * My first thought is to do a merge sort and then find the median making it O(n log n) time complexity
     */


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int [nums1.length + nums2.length];

        if (merged.length % 2 == 0) {
            return merged[merged.length / 2] + merged[merged.length / 2 - 1] / 2.0;
        }
        return merged[merged.length / 2];
    }

    public static void main(String[] args) {
        medianTwoSortedArrays sol = new medianTwoSortedArrays();
        System.out.println("test of Merge Sort Algorithm O(n log n): ");
        System.out.println("Nums 1: [1, 2], Nums 2: [3]");
        System.out.println("Median: " + sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        System.out.println("Nums 1: [1, 3], Nums 2: [2, 4]");
        System.out.println("Median: " + sol.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}