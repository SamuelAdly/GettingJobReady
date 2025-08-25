import java.util.ArrayList;

public class addTwoNumbers {

    /*
     * Add Two Numbers Linked List Problem is a leetcode medium linked list problem
     * We are given two linked lists of single digit nodes and we must add the corresponding digits together
     * if we get numbers higher than 9 we must carry the one to the next digit
     * so 9 9 will be 8, 1
     * 
     * My brute force but failure attempt tried to do this 
     * my approach was O(n) time and space but requires far more code and steps to complete
     * First we create an arraylist to store the values we get from adding the two nodes
     * then while either list is not null we add the value of the current nodes to the arraylist
     * there are if statements incase one list is longer than the other and we avoid resigning the curr value to a nodes value by adding 
     * this way we ensure that we add the digits correctly and traverse the lists properly without missing anything
     * next we go through the arraylist finding any values > 9 
     * depending on its location either we add it to the next index or we create a new "digit" in the next index for the value to carry over
     * finally we create the new linked list and we return it
     */
    public ListNode addTwoNumbersBrute (ListNode l1, ListNode l2) {
        ArrayList<Integer> result = new ArrayList<>();
        while (l1 != null || l2 != null) {
            int curr = 0;
            if (l1 != null) {
                curr = curr + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curr = curr + l2.val;
                l2 = l2.next;
            }
            result.add(curr);
        }

        for (int i =  0; i < result.size(); i++) {
            if (result.get(i) > 9) {
                int carry = result.get(i) / 10;
                result.set(i, result.get(i) - 10);

                if (i + 1 < result.size()) {
                    result.set(i + 1, result.get(i + 1) + carry);
                } else {
                    result.add(carry);
                }
            }
        }

        if (result.get(0) > 9) {
            result.set(0, result.get(0) - 10);
            result.set(1, result.get(1) + 1);
        }

        ListNode newList = new ListNode(result.get(0));
        ListNode current = newList;
        for (int i = 1; i < result.size(); i++) {
            ListNode newNode = new ListNode(result.get(i));
            current.next = newNode;
            current = newNode;
        }
        return newList;
    }

    /*
     * the far better and less brain aching approach to this problem
     * we create a dummy node and a current node and set the carry to 0 
     * while the linked lists are not null or the carry isnt 0
     * we initialize v1 and v2 to 0 and check if the linked lists are null
     * if they arent we set v1 and v2 to the value of the current node
     * then we add the values of v1 and v2 and the carry
     * we then set the carry to the value of the sum divided by 10
     * we then set the value of the current node to the sum mod 10
     * we then create a new node with the value of the current node
     * we then set the current node to the next node
     * we then set the linked lists to the next node
     * finally we return the dummy node next
     */

    public ListNode addTwoNumbersBest (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        addTwoNumbers sol = new addTwoNumbers();
        System.out.println("Add Two Numbers Linked List Problem");

        ListNode testList1 = new ListNode (1, new ListNode( 2, new ListNode(3)));
        ListNode testList2 = new ListNode (4, new ListNode (5, new ListNode (9)));
        ListNode testList3 = new ListNode (9, new ListNode( 2));
        ListNode testList4 = new ListNode (9);


        System.out.println("Test Case 1:");
        ListNode.printList(testList1);
        ListNode.printList(testList2);

        System.out.println("Results of Brute force O(m + n) time and space:");
        ListNode resultBrute1 = sol.addTwoNumbersBrute(testList1, testList2);
        ListNode.printList(resultBrute1);
        System.out.println("Results of Best case O(m + n) time and O(1) space:");
        ListNode resultBest1 = sol.addTwoNumbersBest(testList1, testList2);
        ListNode.printList(resultBest1);

        System.out.println("Test Case 2:");
        ListNode.printList(testList3);
        ListNode.printList(testList4);

        System.out.println("Results of Brute force O(m + n) time and space:");
        ListNode resultBrute2 = sol.addTwoNumbersBrute(testList3, testList4);
        ListNode.printList(resultBrute2);
        System.out.println("Results of Best case O(m + n) time and O(1) space:");
        ListNode resultBest2 = sol.addTwoNumbersBest(testList3, testList4);
        ListNode.printList(resultBest2);


    }
}
