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


    public static void main(String[] args) {
        reorderLinkedList sol = new reorderLinkedList();
        ListNode test1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        
        sol.reorderList(test1);
        ListNode.printList(test1);
    }
}
