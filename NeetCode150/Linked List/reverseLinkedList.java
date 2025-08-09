public class reverseLinkedList {


    /*
     * The problem is Reverse Linked List which is a leetcode easy linked list problem
     * You are given a linked list and have to reverse it
     * 
     * The recursion solution which is O(n) time and space complexity
     * We first check if the head is null if so we return null meaning we have reached the end of the list
     * We then create a new listnode called newhead and set it to head which is the current node we are at
     * Then we check if head.next is not null meaning the next node exists and we are not at the end of the list
     * if this is true we call the function recursively on head.next and set newhead to the result
     * This will keep happening until we reach the end of the list and then we will start returning back up the call stack
     * As we return back up the call stack we set head.next.next to head which will reverse the link between the current node and the next node
     * Then we set head.next to null which will break the link between the current node and the next node
     * Then we return newhead which is the head of the reversed list
     */
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null) return null;

        ListNode newHead = head;

        if (head.next != null) {
            newHead = reverseListRecursion(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }

    /*
     * The iteration solution which is O(n) time and O(1) space complexity
     * We create two listnodes prev and curr and set prev to null and curr to head
     * We then iterate through the list while curr is not null
     * We create a listnode called next and set it to curr.next
     * Then we set curr.next to prev which will reverse the link between the current node and the previous node
     * Then we set prev to curr which will move the previous node to the current node
     * Then we set curr to next which will move the current node to the next node
     * This will keep happening until we reach the end of the list and curr becomes null
     * At this point prev will be at the head of the reversed list so we return prev
     */
    public ListNode reverseListIteration(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reverseLinkedList sol = new reverseLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.print("Original: ");
        printList(head);

        ListNode rec = sol.reverseListRecursion(head);
        System.out.print("Recursion reversed: ");
        printList(rec);

        ListNode back = sol.reverseListRecursion(rec);
        System.out.print("Original again: ");
        printList(back);

        ListNode it = sol.reverseListIteration(back);
        System.out.print("Iteration reversed: ");
        printList(it);
    }
}
