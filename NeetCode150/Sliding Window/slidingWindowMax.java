import java.util.Arrays;

public class slidingWindowMax {
    
    public int[] maxSlidingWindowBrute(int[] nums, int k) {
        int left = 0, right = k - 1;
        int[] result = new int[nums.length - k + 1];

        if (nums.length == 0 || k == 0) return new int[0];
        if (k == 1) return nums;

        while (right < nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i <=right; i++) { 
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            System.out.print(max + " ");
            result[left] = max;
            left++;
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        slidingWindowMax sol = new slidingWindowMax();
        System.out.println("Test of sliding window max Brute Force:");
        System.out.println("nums = [1,2,1,0,4,2,6], k = 3");
        System.out.println("Expected: [2,2,4,4,6]");
        System.out.println("Output: ");
        int[] result = sol.maxSlidingWindowBrute(new int[]{1,2,1,0,4,2,6}, 3);
        System.out.println("\n" + Arrays.toString(result));
    }
}
