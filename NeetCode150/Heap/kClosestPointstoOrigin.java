import java.util.PriorityQueue;

public class kClosestPointstoOrigin {
    /*
     * K Closest Points to Origin is a medium heap problem on leetcode
     * given an array of points where each point is represented by an array of two integers [x, y]
     * we need to find the k closest points to the origin (0, 0)
     * this approach uses a max heap to keep track of the k closest points
     * the approach has a run time of O(N log k) and space complexity of O(k)
     * 
     * the code starts off by creating a priority queue (max heap) that sorts the points based on their distance from the origin in descending order
     * we use the formula x^2 + y^2 to calculate the distance from the origin and we make the comparator sort in reverse order to create a max heap
     * then we iterate through the points array and add each point to the max heap using the offer method
     * if the size of the heap is greater than k we poll (remove) the farthest point from the heap
     * this way we are only keeping the k closest points in the heap
     * then to keep track of the result we create a 2d array of size k and iterate through the heap and add each point to the result array
     * finally we return the result array
     * 
     * this approach is very similar to the kth largest element in a stream problem but this had a 2d array and a custom comparator
     */
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));
        
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        kClosestPointstoOrigin obj = new kClosestPointstoOrigin();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] closestPoints = obj.kClosest(points, k);
        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
