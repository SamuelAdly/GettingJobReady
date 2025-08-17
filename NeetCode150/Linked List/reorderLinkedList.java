import java.util.ArrayList;

public class reorderLinkedList {

    /*
     * Reorder Linked List is a leetcode medium linked list problem
     * you are given a linked list and must reorder it as [0, n-1, 1, n-2, 2, n-3, ...]
     * This pattern is basically take left shift over one, take right shift over one. almost like a zigzag pattern from both ends 
     * 
     * For my first approach it reminded me of the two pointer technique but since we are using singly linked lists it wouldnt be possible to have a right pointer
     * This way I decided to create an arraylist with the values stored inside to be the nodes themselves
     * This approach takes O(n) time and space complexity
     * we first make sure that the head or the next pointer isnt null because there would be no reason to reorder a linked list of less than 2 nodes
     * then we create the arraylist and populate it using the while loop
     * then we initialize our left and right pointers and set the head to be the first value in the arraylist
     * we use a while loop to ensure the two pointers dont cross each other
     * we set the next pointer of our current head to be the right value in the arraylist which is a node
     * we then set the current head to be the next node in the arraylist and move the right pointer to the left by 1
     * for the left pointer we do not want to add the same node as the right pointer so we check if the left pointer is still less than the right pointer
     * we then increase left by 1 since we had it as 0 and that was where the head was first set
     * we then set the next pointer of our current head to be the left value in the arraylist which is a node and shift the current head to the next node in the arraylist
     * when its all done we set the final pointer to null since our linked list is done
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        head = list.get(left);
        while (left < right) {
            head.next = list.get(right);
            head = head.next;
            right--;

            if (left < right) {
                left++;
                head.next = list.get(left);
                head = head.next;
            }
        }
        head.next = null;
    }


    /*
     * This solution takes O(n) time but O(1) space 
     * first we start off as usual making sure that the linked list is even large enough for us to reorder
     * then we use the slow and fast pointer approach to locate the middle of the linked list
     * By the time the fast pointer reaches the end it would mean that the slow is half way across the linked list (AKA the Middle)
     * this is simply done using a while loop while we are not at null (end for linked lists) we move slow by 1 and fast by 2
     * Next we want to reverse the right side of the linked list
     * we set the second pointer to be the next node of the slow pointer which is the middle of the linked list
     * we also set the previous pointer to be the next node of the slow pointer but we set it to null so that we can reverse the linked list
     * we then use a while loop to reverse the right side of the linked list by setting the next pointer of the second node to be the previous node
     * Finally we need to merge the linked list by doing left right left right and so on
     * so we create a new listnode called first and assign it to the head meaning that will be our left/first node to be added
     * second will become equal to prev which is the right side of the linked list
     * we then use a while loop to merge the linked list by setting the next pointer of the first node to be the second node
     * then we set the first node to be the next node of the first node
     * then we set the second node to be the next node of the second node
     * this will continue until the second node is null meaning that we have reached the end of the linked list
     */
    public void reorderListBest(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next, prev = slow.next = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }


    public static void main(String[] args) {
        reorderLinkedList sol = new reorderLinkedList();
        ListNode test1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode test2 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        
        System.out.println("Reorder Linked List Test O(n) time and space \nOriginal: ");
        ListNode.printList(test1);
        sol.reorderList(test1);
        System.out.println("Reordered: ");
        ListNode.printList(test1);

        System.out.println("Reorder Linked List Test O(n) time and O(1) space \nOriginal: ");
        ListNode.printList(test2);
        sol.reorderListBest(test2);
        System.out.println("Reordered: ");
        ListNode.printList(test2);
    }
}
