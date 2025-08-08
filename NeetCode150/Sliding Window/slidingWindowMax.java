import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMax {
    /*
     * Sliding window maximum problem is a leetcode hard sliding window problem
     * you are given an int array nums and an int k
     * K is the size of the allowed window you cant have smaller or larger windows
     * you then must use that window size to go through the array and find the max within that window
     * as you go right you must remove the leftmost element aka slide like a window
     * The brute force solution takes O(n * k) time complexity 
     * We simply set up the window and that window will slide as we go through the array
     * But with each window we iterate through the entire window to find the max therefore creating a loop of size k at almost every index of the array
     * 
     * The best solution is to use a deque which is a double ended queue and it takes O(n) time complexity
     * We will use the deque to store the indices of the elements in the current window
     * We will maintain the deque such that the elements in the deque are in decreasing order
     * We will use the deque to find the max element in the current window
     * We will also remove the elements from the deque that are out of the current window
     * This way we can find the max element in O(1) time
     * 
     * For the code we first initialize all the variables and data structures we need (result array, deque, left and right pointers)
     * Then we iterate through the array using the right pointer
     * while the queue is not empty and the number at the last index of the queue is smaller than the number at the right pointer we remove the last index from the queue
     * This is because the new number will be the new max therefore any number smaller than it wont be needed in the queue
     * Then we add the index of the current number to the queue
     * If the left pointer is greater than the first index in the queue we remove the first index from the queue
     * If the we have reached the size of the window the number at the front of the queue is the biggest in the current window so we put it into the result array and increment the left pointer
     */
    



    public int[] maxSlidingWindowBest(int[] nums, int k) {
        int [] result = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int left = 0, right = 0;

        while (right < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            q.addLast(right);

            if (left > q.getFirst()) {
                q.removeFirst();
            }

            if ((right + 1) >= k) {
                result[left] = nums[q.getFirst()];
                left++;
            }
            right++;
        }
        return result;
    }

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
        System.out.println("\nTest of sliding window max Best:");
        System.out.println("nums = [1,2,1,0,4,2,6], k = 3");
        System.out.println("Expected: [2,2,4,4,6]");
        System.out.println("Output: ");
        result = sol.maxSlidingWindowBest(new int[]{1,2,1,0,4,2,6}, 3);
        System.out.println(Arrays.toString(result));
    }
}
