import java.util.ArrayList;

public class removeNthNodeFromEnd {

    /* This leetcode problem is a linked list medium problem
     * Given a linked list, remove the n-th node from the end of the list and return the head
     * My first approach is to simply store all the nodes in an arraylist, remove the nth from the end, and rebuild the linked list using the nodes in the arraylist
     * This approach takes O(n) time and space complexity
     * first we check edge cases like getting an empty list or an n less than 1
     * then we just initialize our arraylist and loop through the linked list adding all the nodes 
     * after, we remove the nth node and if that results in an empty list, we return null
     * otherwise, we rebuild the linked list using the nodes in the arraylist and return the head
     */
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) return null;

        ArrayList<ListNode> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }

        arr.remove(arr.size() - n);
        if (arr.isEmpty()) return null;

        head = arr.get(0);
        ListNode current = head;
        for (int i = 1; i < arr.size(); i++) {
            current.next = arr.get(i);
            current = current.next;
        }
        current.next = null;

        return head;
    }


    /*
     * This is the best approach for this problem which takes O(n) time and O(1) space complexity
     * We use a two-pointer technique where we have a left pointer and a right pointer
     * We first create a dummy node with a value of 0 that points to the head of the linked list
     * we also create left and right pointers where left is the dummy node and right is the head
     * We then move the right pointer n steps ahead
     * After that, we move both pointers until the right pointer reaches the end of the linked list
     * When the right pointer reaches the end, the left pointer will be at the node before the one we want to remove
     * We then set the next pointer of the left pointer to be the next pointer of the left pointer's next node, effectively removing the nth node from the end
     * Finally, we return the next pointer of the dummy node which is the new head of the linked list
     */
    public ListNode removeNthFromEndBest(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }
        
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    public static void main (String[] args) {
        removeNthNodeFromEnd sol = new removeNthNodeFromEnd();
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode test2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        sol.removeNthFromEnd(test1, 2);
        sol.removeNthFromEndBest(test2, 2);
        ListNode.printList(test1);
        ListNode.printList(test2);
    }
}
