public class medianTwoSortedArrays {
    /*
     * This leetcode problem involves finding the median of two sorted arrays.
     * The median is the middle value in a sorted array. If the array has an even number of elements, the median is the average of the two middle numbers.
     * If it is odd, its the middle number.
     * My first thought is to do a merge sort and then find the median making it O(n + m) time complexity
     * The best solution uses binary search to find the median making it O(log(n + m))
     * This solution tries to find an intersection point between the two arrays. The smaller array uses binary search to find half of the total length of both arrays while also being less than or equal to the right partition
     * This means that we partition the two arrays into left and right halves (wont actually be half of the arrays but half of the total length of both arrays) and we want to make it so that the last value in the left partition is less than or equal to the first value in the right partition of the opposite array.
     * Then we just find the median based on the total length of both arrays.
     */


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int [nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        if (merged.length % 2 == 0) {
            double median = (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2.0;
            return median;
        }
        return merged[merged.length / 2];
    }

    public double findMedianSortedArraysBest(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int left = 0, right = nums1.length;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;


            int nums1left = i > 0 ? nums1[i - 1]: Integer.MIN_VALUE; // left partition of nums1 so if i > 0 then we can safely access the element left of the partition but if i == 0 that means we are at the start of nums1 and anything to the left is out of bounds
            int nums1right = i < nums1.length ? nums1[i] : Integer.MAX_VALUE; // right partition of nums1 if i == nums1.length then we are at the end of nums1 else the element at i is the first element of the right partition
            int nums2left = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE; // same as nums1 left partition but for nums2
            int nums2right = j < nums2.length ? nums2[j] : Integer.MAX_VALUE; // same as nums1 right partition but for nums2

            if (nums1left <= nums2right && nums2left <= nums1right) { // just checks if everything on the left partition is less than or equal to everything on the right partition. If true we calculate the median else adjust partitions
                if(total % 2 != 0) {
                    return (Math.max(nums1left, nums2left));
                } return (Math.max(nums1left, nums2left) + Math.min(nums1right, nums2right)) / 2.0;
            } else if (nums1left > nums2right) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        medianTwoSortedArrays sol = new medianTwoSortedArrays();
        System.out.println("test of Merge Sort Algorithm O(n + m): ");
        System.out.println("Nums 1: [1, 2], Nums 2: [3]");
        System.out.println("Median: " + sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        System.out.println("Nums 1: [1, 3], Nums 2: [2, 4]");
        System.out.println("Median: " + sol.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) + "\n");
        
        System.out.println("test of Best Solution O(log(n + m)): ");
        System.out.println("Nums 1: [1, 2], Nums 2: [3]");
        System.out.println("Median: " + sol.findMedianSortedArraysBest(new int[]{1, 2}, new int[]{3}));
        System.out.println("Nums 1: [1, 3], Nums 2: [2, 4]");
        System.out.println("Median: " + sol.findMedianSortedArraysBest(new int[]{1, 3}, new int[]{2, 4}));
    }
}