import java.util.ArrayList;
import java.util.List;

class kthSmallestElement {

    /*
     * Kth Smallest Element in a BST is a medium tree problem on leetcode
     * given a binary search tree we must return the kth smallest element in the tree
     * Since binary trees have the property that the left child is smaller than the parent and the right child is larger than the parent
     * we can do an inorder traversal of the tree to get the elements in sorted order
     * we then store those elements in an array list and return the kth element
     * the approach I did is O(n) time and O(n) space complexity
     * we first create the result list as an array list so we can dynamically add elements to it
     * then we call the inorder function with the root node and the result list
     * the inorder function is a recursive function that will traverse the tree and add the value of each node to the result list
     * we start off by checking if the node is null if so we return since there is nothing to add
     * then we call the inorder function with the left child node and the result list because we want to visit the left child before adding the parent
     * then we add the value of the node to the result list
     * then we call the inorder function with the right child node and the result list because we want to visit the right child after adding the parent
     * finally we return the result list
     */

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result.get(k - 1);
    }

    public void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public static void main(String[] args) {
        kthSmallestElement solution = new kthSmallestElement();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}