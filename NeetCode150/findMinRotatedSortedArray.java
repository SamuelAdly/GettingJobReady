public class findMinRotatedSortedArray {
    /*
    - The find minimum in rotated sorted array problem asks that given a rotated sorted array we need to find the minimum value in the array. This means that it was sorted but the values have been shifted around a bit and is sorted at certain points.
    - The brute force solution is to iterate through the entire array and keep track of the minimum value we have seen so far.
    - The best approach takes O(log n) time complexity and it involves using binary search. While the problem appears to be tricky because its rotated, we actually do a basic binary search.
    - We have a left and right pointer and we calculate mid. The reason binary search works is because the array is sorted but rotated so the first element will be the value after the rotation.
    - If I had [3, 4, 5, 1 , 2] the left = 3 right = 2 and mid = 5. and this tells me that the sorted array had 2 then 3. You can think of it as the point in which they switched places.
    - Therefore if we find that mid is smaller than right we know that the smaller portion of the original array is on the right side of mid. Else it is on the left side if we rotated a lot.
     */
    public int findMinBrute (int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public int findMinBest (int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
    

    public static void main(String[] args) {
        findMinRotatedSortedArray sol = new findMinRotatedSortedArray();
        System.out.println("Find Minimum in Rotated Sorted Array Tests");
        System.out.println("Brute Force Solution (O(n))");
        System.out.println(" Array:[3,4,5,6,1,2] Solution: " + sol.findMinBrute(new int[]{3,4,5,6,1,2}));
        System.out.println(" Array:[4,5,0,1,2,3] Solution: " + sol.findMinBrute(new int[]{4,5,0,1,2,3}));
        System.out.println(" Array:[4,5,6,7] Solution: " + sol.findMinBrute(new int[]{4,5,6,7}));
        System.out.println("Best Solution (O(log n))");
        System.out.println(" Array:[3,4,5,6,1,2] Solution: " + sol.findMinBest(new int[]{3,4,5,6,1,2}));
        System.out.println(" Array:[4,5,0,1,2,3] Solution: " + sol.findMinBest(new int[]{4,5,0,1,2,3}));
        System.out.println(" Array:[4,5,6,7] Solution: " + sol.findMinBest(new int[]{4,5,6,7}));
    }
}
