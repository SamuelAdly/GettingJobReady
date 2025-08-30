public class reverseNodesInKGroup {

    /*
     * Reverse Nodes in k-Group is a hard leetcode linked list problem
     * You are given a linked list and an integer k
     * You have to reverse the nodes of the list k at a time and return the modified list
     * The recursion solution which is O(n) time and O(1) space complexity
     * first we start off by initializing a listnode called curr to head which is the current node we are at
     * int count will keep count of the number of nodes we have visited
     * we then use a while loop to check if there are at least k nodes left in the list
     * if we have k nodes then we reverse them
     * if count == k then we call the function recursively on curr which is the next part of the list after k nodes since curr was moved k times in the first while loop
     * then we use a while loop to reverse the nodes by storing the next node in a listnode called temp
     * then we reverse the link between the current node and the next node by setting head.next to curr
     * then we move curr to head since head is now the new head of the reversed part
     * then we move head to temp which is the next node in the original list
     * after reversing we set head to curr since curr is the new head of this segment
     * finally we return head
     */

    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k); 
            while (count-- > 0) {
                ListNode temp = head.next; 
                head.next = curr;          
                curr = head;               
                head = temp;               
            }
            head = curr;
        }
        return head;
    }



    public static void main (String[] args) {
        reverseNodesInKGroup sol = new reverseNodesInKGroup();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode newHead = sol.reverseKGroup(head, k);
        System.out.print("Reversed List: ");
        ListNode.printList(newHead);
    }
}