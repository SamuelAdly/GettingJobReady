public class subtreeOfAnotherTree {
    /*
     * The problem is Subtree of Another Tree which is an easy tree problem on leetcode
     * the problem provides you with two binary trees and you must determine if the second tree is a subtree of the first tree
     * a subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants
     * the approach I did was a basic recursion approach which is O(m*n) time complexity and O(m+n) space complexity
     * we start off by checking if the root is null if it is we return false since an empty tree cannot have a subtree
     * next we check if our helper function returns true if so we return true since it means the helper found a match
     * then we recursively call the function on the left and right children of the root and check if either of them returns true
     * the helper function is used to check if two trees are identical
     * we start off with the base cases which are if both are empty, one is empty, or they are not equal.
     * These will return their respective results
     * otherwise we recursively call the function on the left and right children of both trees
     */

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        subtreeOfAnotherTree tree = new subtreeOfAnotherTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(4);
        subRoot.right = new TreeNode(5);
        System.out.println("Is subtree: " + tree.isSubtree(root, subRoot));
    }
}
