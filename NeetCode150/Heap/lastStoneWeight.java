import java.util.Collections;
import java.util.PriorityQueue;

class lastStoneWeight {
    /*
     * Last Stone Weight is an easy heap problem on leetcode
     * given an array of stones where each stone has a positive integer weight
     * we need to smash the two heaviest stones together until there is one or no stones left
     * this can be done using a max heap keeping the largest stones at the top rather than a min heap keeping the smallest stones at the top
     * the approach has a run time of O(N Log N) and space complexity of O(N)
     * 
     * first we start off by creating the max heap and we give it the sorting order of reverse order using collections.reverseorder()
     * then we iterate through the stones array and simply add them to the max heap using the offer method
     * then we enter a while loop that only ends if we have one or no stones left in the heap
     * inside the while loop we create two variables first and second and assign them the values of the top two elements in the heap
     * then we check if the two stones are not equal because that would mean there would be one that is left over and needs to be added back to the heap
     * if they are equal we would have to add nothing since they would both be destroyed
     * then we just return 0 or the top element depending on the boolean from pq.isempty()
     */

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first != second) {
                pq.offer(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }




    public static void main(String[] args) {
        lastStoneWeight obj = new lastStoneWeight();
        int[] stones = {2, 3, 6, 2, 4};
        System.out.println(obj.lastStoneWeight(stones));
    }
}