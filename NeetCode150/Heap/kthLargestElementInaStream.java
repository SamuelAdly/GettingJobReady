
import java.util.PriorityQueue;

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
