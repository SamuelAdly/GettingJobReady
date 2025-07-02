public class findMinRotatedSortedArray {
    /*
    - The find minimum in rotated sorted array problem asks that given a rotated sorted array we need to find the minimum value in the array. This means that it was sorted but the values have been shifted around a bit and is sorted at certain points.
    - The brute force solution is to iterate through the entire array and keep track of the minimum value we have seen so far.
    - 
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
        int min = 0;
        return min;
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
        System.out.println(" Array:[4,5,6,7] Solution: " + sol.findMinBest(new int[]{14,5,6,7}));
    }
}
