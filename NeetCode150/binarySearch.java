class binarySearch {
    /*  
    This question gives you a sorted array and a target value and you need to return the index of the target.
    The approach for Binary Search to get the time complexity of O(log n) is to perform the divide and conquer technique
    To do this we need a left and right pointer. Since the array is already sorted we use a middle pointer that does the actual finding.
    the first case is that we start at the very middle of the array and look for the value. If the middle is too large we shift to looking at the left half of the array. 
    If it is small we look at the right half.
    We repeat this until we find the value or the left and right pointers cross each other and return -1
    */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + right / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binarySearch sol = new binarySearch();
        System.out.println("Binary Search Tests");
        System.out.println(" Array:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Target: 10 Solution(index): " + sol.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(" Array:[1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 20, 22, 24, 25] Target: 1 Solution(index): " + sol.search(new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 20, 22, 24, 25}, 1));
    }
}