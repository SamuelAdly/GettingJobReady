
import java.util.PriorityQueue;

class kthLargestElementInArray {

    /*
     * Kth Largest Element in an Array is a medium heap problem on leetcode
     * for some reason this problem is listed as medium but it is actually quite easy
     * given an array of numbers and a number k we need to find the kth largest element in the array
     * the approach uses a min heap to keep track of the k largest elements in the array
     * this is the same approach we have done for all the previous problems in which we make the minheap and only keep k elements in it
     * the approach has a run time of O(N log k) and space complexity of O(k)
     * 
     * first we start off by creating a priority queue (min heap)
     * then we iterate through the nums array and add each element to the min heap using the offer method
     * when the size of the heap is greater than k we poll aka remove the smallest element from the heap
     * this way we are only keeping the k largest elements in the heap
     * then we return the smallest element (the kth largest) element which is at the top of the heap by returning the peek method
     */
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main (String[] args) {
        kthLargestElementInArray kth = new kthLargestElementInArray();
        int[] nums = {2, 3, 1, 5, 4};
        int k = 2;
        System.out.println("The " + k + "th largest element is: " + kth.findKthLargest(nums, k));
    }

}