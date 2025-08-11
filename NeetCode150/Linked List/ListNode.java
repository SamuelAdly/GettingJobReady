
    /*
     * This code was part of the problem for reversing a linked list
     * the code is for the construction of the listnodes
     * In a linked list we have a chain of nodes (think of balls of info connected by a string like a pearl necklace), each node has a value and a pointer to the next node
     * This class called ListNode takes in a value and a listnode for next.
     * Its constructors then allow the user to pass no value, a value, or a value and next for the 3 cases of creating a listnode
     */
    
    public class ListNode {
        public int val;
        public ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }