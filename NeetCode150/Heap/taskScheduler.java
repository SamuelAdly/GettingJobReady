import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class taskScheduler {

    /*
     * Task Scheduler is a medium heap problem on leetcode
     * given an array of characters representing tasks and a non-negative integer n representing the cooldown period
     * we need to find the least number of units of time that the CPU will take to finish all the given tasks
     * 
     * for this approach we use a maxheap and a queue to complete the problem
     * this gives us a run time of O(M) and space complexity of O(1) where M is the number of tasks
     * we use the maxheap to store the number of occurrences of each task and the queue to keep track of the cooldown period for each task
     * 
     * first we start off by finding the count of each task using the count array
     * we iterate through the tasks array and increment the count of each task using the formula tasks[i] - 'A' to map the characters to the count array since we only have uppercase letters
     * we then create the maxheap and add the counts of each task to the maxheap
     * then we create the time variable to keep track of the total time taken to complete all tasks
     * we create the queue to keep track of the cooldown period for each task
     * then we enter a while loop that continues until both the maxheap and the queue are empty
     * in each iteration of the while loop we increment the time variable by 1
     * if the maxheap is empty we set the time variable to the time when the next task in the queue will be available
     * otherwise we poll the maxheap to get the task with the highest count and decrement its count by 1
     * if the count is greater than 0 we add it to the queue with the time when it will be available again (current time + n)
     * then we check if the front of the queue is available to be added back to the maxheap (i.e., its cooldown period is over)
     * if it is we poll the queue and add the task back to the maxheap
     * then we return the time variable which represents the least number of units of time to finish all tasks
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                maxHeap.add(count[i]);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }

    public static void main (String[] args) {
        taskScheduler task = new taskScheduler();

        char[] tasks1 = {'X','X','Y','Y'};
        System.out.println(task.leastInterval(tasks1, 2));

        char[] tasks2 = {'A','A','A','B','C'};
        System.out.println(task.leastInterval(tasks2, 3)); 
    }
}
