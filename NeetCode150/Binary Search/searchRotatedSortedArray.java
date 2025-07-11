public class searchRotatedSortedArray {

/*
- This problem asks us to search for a target value in a rotated sorted array.
- The brute force solution which is O(n) time complexity is just to iterate through the entire array and check if the current element is equal to the target.
- The best solution which is O(log n) time complexity uses binary search but modifies it
- It involves the original approach where we have left right and mid pointers but the different is that we need to check if the left side is sorted or the right side is sorted.
- The first if (nums[mid] == target) just checks if mid is the target and returns it which would be nice to always get.
- Then we have if (nums[left] <= nums[mid]) { which checks if the left side of mid is sorted by seeing if left is less than or equal to mid.
- If it is sorted then we check if the target is greater than mid or less than left. This is because if this array is sorted and we explore it then target will not be there if it is less than the smallest and greater than the largest in the sorted array.
- If its false then the right half becomes the new search space.
- Then it also checks if the right side is sorted in a similar manner.
 */

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
            return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                } else {
                    if (target < nums[mid] || target > nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
        }
        return -1;
    
    }
    

    public static void main(String[] args) {
        searchRotatedSortedArray sol = new searchRotatedSortedArray();
        System.out.println("Search in Rotated Sorted Array Tests");
        System.out.println(" Array:[3,4,5,6,1,2] Target: 1 Solution(index): " + sol.search(new int[]{3,4,5,6,1,2}, 1));
        System.out.println(" Array:[3,5,6,0,1,2] Target: 4 Solution(index): " + sol.search(new int[]{3,5,6,0,1,2}, 4));
        System.out.println(" Array:[4,5,6,7,0,1,2] Target: 0 Solution(index): " + sol.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
