
import java.util.HashSet;

public class linkedListCycleDetection {

    /*
     * Linked List Cycle Detection is a leetcode easy linked list problem.
     * You are given a linked list and asked to determine if there is a cycle
     * A cycle in a linked list or graphs are the same, this means that we are looking for a loop that goes back to a previous node
     * 
     * My first approach is to use a hashset and just iterate through the linked list adding each node if its new
     * If the node already exists in the hashset then that means we have a cycle so return false
     * this is O(n) time complexity and space complexity so it is good time complexity but not the best space complexity (space is cheap but this can be improved)
     */

    public boolean hasCycleHS(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /*
     * This approach uses two pointer
     * we use two pointers, slow and fast to iterate through the linked list
     * slow moves one node at a time and fast moves two nodes at a time
     * if there is a cycle then the fast pointer will eventually catch up to the slow pointer
     * if there is no cycle then the fast pointer will reach the end of the linked list
     * this is O(n) time complexity and O(1) space complexity 
     * The code first initializes the two pointers to head
     * then we use a while loop to iterate through the linked list so that the current fast node and its next node are not null
     * the first case is when slow and fast are on the same head node therefore we move slow by one and fast by two (in the first run slow is on head+1 and fast is on head+2)
     * we check if they are equal and if they are then we return true
     * if they are not equal we loop back and keep going until we find a cycle or reach the end of the linked list
     */
    public boolean hasCyclePointers(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        linkedListCycleDetection sol = new linkedListCycleDetection();
        System.out.println("Linked List Cycle Detection Test");
        System.out.println("head = [1,2,3,4], index = 1");
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println("Expected: true");
        System.out.println("Actual for HeapSet: " + sol.hasCycleHS(test1));
        System.out.println("Actual for Two Pointers: " + sol.hasCyclePointers(test1));
        System.out.println("head = [1,2], index = -1");
        ListNode test2 = new ListNode(1, new ListNode(2));
        System.out.println("Expected: false");
        System.out.println("Actual for HeapSet: " + sol.hasCycleHS(test2));
        System.out.println("Actual for Two Pointers: " + sol.hasCyclePointers(test2));
    }
}
