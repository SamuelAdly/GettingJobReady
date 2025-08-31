public class sameBinaryTree {
    
    /*
     * Same Binary Tree is an easy Tree leetcode problem
     * the problem provides you with two trees and you must check if they are the same tree or not
     * if they are return true if not return false
     * the approach I did was a basic recursion approach which is O(n) time and O(h) space complexity where h is the height of the tree
     * we simply check the value of each node and recurse on the left and right children
     * we start off by checking the three base cases which are if both are empty, one is empty, or both are not equal
     * then we call the function again on the left and right children
     *  this will create a stack of calls that will check each node in the tree and give us the answer
     */
    public boolean isSameTree (TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        sameBinaryTree tree = new sameBinaryTree();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        TreeNode p2 = new TreeNode(3, new TreeNode(5), new TreeNode(1));
        TreeNode q2 = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        System.out.println(tree.isSameTree(p, q));
        System.out.println(tree.isSameTree(p2, q2));
    }
}
