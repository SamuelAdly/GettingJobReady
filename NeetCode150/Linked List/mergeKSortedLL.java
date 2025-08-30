import java.util.PriorityQueue;

public class mergeKSortedLL {
    /*
     * Merge k Sorted Lists is a hard leetcode linked list problem
     * You are given an array of k linked lists each sorted in ascending order
     * You have to merge all the linked lists into one sorted linked list and return it
     * This approach uses a priority queue or min heap to keep track of the smallest node among the k lists and is O(N log k) time complexity and O(k) space complexity
     * we start off by creating a priority queue that sorts the list nodes based on their values with integer.compare(a.val, b.val)
     * then we loop through the input array of lists and add the head of each non-null list to the priority queue
     * we then create two pointers result and resultEnd to keep track of the merged list
     * result is the head and resultEnd keeps track of the last node added to the new list
     * then while the pq is not empty we take out the smallest node
     * if we have not started a merged list yet then result = smallest is the head else we attach smallest to the end of the merged list and move the pointer
     * then we have to add the next node from the same list of the smallest node we just added
     * after everything we return the merged list
     */

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode result = null;
        ListNode resultEnd = null;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            if (result == null) {
                result = smallest;
            } else {
                resultEnd.next = smallest;
            }
            resultEnd = smallest;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }
        return result;
    }
    

    public static void main (String[] args) {
        mergeKSortedLL sol = new mergeKSortedLL();
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {list1, list2, list3};
        ListNode mergedList = sol.mergeKLists(lists);
        System.out.print("Merged List: ");
        ListNode.printList(mergedList);
    }
}
