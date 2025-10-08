
import java.util.PriorityQueue;
/*
 * kth largest element in a stream is an easy heap problem on leetcode
 * the problem asks you to find the kth largest element in a stream of numbers
 * the stream is represented by an array of numbers and we are given a number k
 * we need to implement a class that has a constructor that takes in k and the array of numbers
 * we also need to implement a method that takes in a number and adds it to the stream
 * 
 * the approach for this is to use a priority queue (min heap) to store the array of numbers but only up to K elements
 * so we would be iterating through the nums array and adding each element to the pq but when the size is greater than K we will start polling (removing) the smallest element 
 * this will leave us with the K largest elements and the smallest (the kth largest) element will be at the top of the pq
 * the add method will do the same thing we will add the new element to the pq and if the size is greater than K we will poll the smallest element
 * then we will return the smallest element (the kth largest) element which is at the top of the pq
 * time complexity is O(M * log k) and space complexity is O(k)
 * 
 * The code starts off by creating a priority queue and an integer k to store the value of k
 * the constructor takes in K and the array of numbers and iterates through the array and adds each element to the pq using the built in offer method but when the size is greater than K we poll the smallest element
 * the add method takes in a number and adds it to the pq and if the size is greater than K we poll the smallest element
 * then we return the smallest element (the kth largest) element which is at the top of the pq
 */

public class kthLargestElementInaStream {
    PriorityQueue<Integer> pq;
    int k;

    public kthLargestElementInaStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        kthLargestElementInaStream kth = new kthLargestElementInaStream(k, nums);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
        System.out.println(kth.add(10));
        System.out.println(kth.add(9));
    }
    
}
