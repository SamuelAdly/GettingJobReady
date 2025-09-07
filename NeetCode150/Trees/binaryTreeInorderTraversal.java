import java.util.ArrayList;
import java.util.List;

public class binaryTreeInorderTraversal {

    /*
     * The problem is Binary Tree Inorder Traversal which is an easy tree problem on leetcode
     * the problem provides you with a binary tree and you must return the inorder traversal of its nodes' values
     * inorder traversal is when we visit the left subtree first, then the current node, and finally the right subtree
     * the approach I did was a basic recursion approach which is O(n) time and O(h) space complexity where h is the height of the tree
     * we start off by checking the node if it is null we return since there is nothing to add to our list
     * otherwise we recursively call the function on the left child, add the value of the current node to our list, and then recursively call the function on the right child
     * this will create a stack of calls that will traverse each node in the tree and add its value to our list in inorder fashion
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        inorder(root,values);
        return values;
    }

    public static void inorder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        inorder(root.left, values);
        values.add(root.val);
        inorder(root.right, values);
    }


    public static void main(String[] args) {
        binaryTreeInorderTraversal tree = new binaryTreeInorderTraversal();
        TreeNode p = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(tree.inorderTraversal(p));
    }
}
