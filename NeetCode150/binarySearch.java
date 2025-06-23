class binarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
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
        System.out.println(sol.search(new int[]{1,2,3,4,5,6,7,8,9,10}, 10));
        System.out.println(sol.search(new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 20, 22, 24, 25}, 1));
    }
}