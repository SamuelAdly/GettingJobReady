import java.util.HashMap;
import java.util.Map;

public class copyLinkedListWithRandomPointer {
    /*
     * Copy Linked List With Random Pointer is a leetcode Medium Linked List problem
     * you are given a linked list and you need to make a deep copy of it
     * rather than just having the next pointer you are also given a random pointer
     * the random pointer can point to any node in the linked list or be null so the challenge is that if you are trying to make a deep copy
     * you need to make sure that the random pointer has a node to go to and we know that the fastest time to traverse a LL is O(n)
     * therefore if my first node points to a node at the end then it is a problem to create the deep copy without setting that pointer to the copy
     * 
     * This approach does two passes
     * The first pass just creates the nodes and stores them in a map where the old node is the key and the new node is the value
     * The second links the pointers
     * We first start by creating a hashmap with nodes as the key and the value
     * we set the first value to null so that we can handle the edge case of a random pointer being null
     * we then initialize a current pointer to the head
     * while this current pointer is not null we go through the original linked list and create copies of the nodes then map them to our hashmap
     * On the second pass we start at head again but this time we go through the linked list and link the pointers
     * we get the copy of the current node and set the next and random pointers to the copy of the next and random nodes
     * we then return the copy of the head node
     */
    
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);
        Node cur = head;
        while(cur != null) {
            Node copy = new Node(cur.val);
            oldToCopy.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }
        return oldToCopy.get(head);
    }

    public static void main(String[] args) {
        copyLinkedListWithRandomPointer sol = new copyLinkedListWithRandomPointer();
        System.out.println("Test runs");
        // Construct linked list: 3 -> 7 -> 4 -> 5
        Node test1 = new Node(3);
        test1.next = new Node(7);
        test1.next.next = new Node(4);
        test1.next.next.next = new Node(5);
        Node result = sol.copyRandomList(test1);

        System.out.println("Head value: " + test1.val);
        System.out.println("Head value: " + result.val);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


