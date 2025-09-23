public class validBinarySearchTree {
    /*
     * Valid Binary Search Tree is a medium tree problem on leetcode
     * the problem provides you with a binary tree and you must determine if it is a valid binary search tree
     * a valid binary search tree is defined as a tree where for every node, all values in the left subtree are less than the node's value and all values in the right subtree are greater than the node's value
     * the approach I did was a recursive approach which is O(n) time and O(n) space complexity
     * it performs a top down approach where we traverse the tree and check if each node satisfies the binary search tree properties
     * we start off by checking if the root is null, if it is we return true since an empty tree is a valid binary search tree
     * otherwise we call the validator function on the root node with initial min and max values set to negative and positive infinity respectively
     * the validator function is what does the work of checking if the node satisfies the binary search tree properties and returns true or false
     * we start off by checking if the node is null, if it is we return true since an empty tree is a valid binary search tree
     * otherwise we check if the value of the node is less than the min or greater than the max, if it is we return false since the node does not satisfy the binary search tree properties
     * otherwise we call the validator function on the left and right children with the min and max values updated with the value of the current node
     * finally we return the result of the left and right calls
     * the function continues to recursively call itself until all nodes have been visited and the result is returned
     */
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return validator(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validator (TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return validator(root.left, min, root.val) && validator(root.right, root.val, max);
    }

    public static void main (String[] args) {
        validBinarySearchTree solution = new validBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution.isValidBST(root));
    }
}
