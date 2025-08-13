public class mergeTwoSortedLL {

    /*
     * Merge two sorted linked lists is a linked list easy problem on leetcode
     * You are given two sorted linked lists and have to merge them into one sorted linked list
     * the methods are almost like two pointer in which we have list1 and list2 and we just compare values and add a node then move that linked lists pointer
     * 
     * The recursive method which is O(n + m) time complexity and space
     * the method uses the base case of either list being null meaning either we have reached the end of that list or it was empty to begin with
     * if they are not empty we compare the values
     * if list1.val is less than or equal to list2.val we keep list1 and set its next pointer to the recursive call with parameters list1.next and list2 
     * we then return list1 and the else just does that for list2 instead
     * 
     * An example run is if we had 1 3 5 and 2 4 6
     * we first compare 1 and 2 and keep 1 since it is smaller
     * therefore we have list1.val as 1 and list1.next as a pointer to the recursive call with the list1.next and list2
     * by returning list1 we have the node with value 1
     * this will then compare 3 and 2 and keep 2
     * therefore we have list1.val as 2 and list1.next as a pointer to the recursive call with the list1.next and list2
     * by returning list2 we have the node with value 2 and so on
     */

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursion(list1, list2.next);
            return list2;
        }
    }

    /*
     * The iterative method is also O(n + m) time complexity but it is O(1) space complexity since we do not use a call stack like recursion
     * For this method we create a dummy or temp listnode as a placeholder to start the merged list
     * then we create a pointer node which will be used to traverse the merged list called node
     * we then loop while both list1 and list2 are not null 
     * if list1.val is less than or equal to list2 than we want list1 over list2
     * therefore we use that pointer node and set its pointer for the next node to list1 and set list1 to list1.next
     * otherwise we just do the same thing for list2
     * The bottom if statements simply keep the merging going for whichever list still has nodes since there are many edge cases where one list may be longer, sorted differently, or even empty
     * then we just return temp.next which is the head of the merged list
     */
    public ListNode mergeTwoListsIteration(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode node = temp;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        mergeTwoSortedLL sol = new mergeTwoSortedLL();
        ListNode list1R = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2R = new ListNode(1, new ListNode(3, new ListNode(5)));
        System.out.print("List 1: ");
        ListNode.printList(list1R);
        System.out.print("List 2: ");
        ListNode.printList(list2R);
        System.out.println("Expected: [1,1,2,3,4,5]");
        System.out.print("Recursive Actual: ");
        ListNode.printList(sol.mergeTwoListsRecursion(list1R, list2R));

        ListNode list1I = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2I = new ListNode(1, new ListNode(3, new ListNode(5)));
        System.out.print("Iterative Actual: ");
        ListNode.printList(sol.mergeTwoListsIteration(list1I, list2I));
    }

}