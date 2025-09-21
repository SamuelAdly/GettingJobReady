public class lowestCommonAncestorBST {
    
    /*
     * Lowest Common Ancestor of a Binary Tree is a medium tree problem on leetcode
     * given a binary tree and two nodes p and q we must return the lowest common ancestor of the two nodes
     * the lowest common ancestor is defined as the lowest node in the tree that has both p and q as descendants (a node can be a descendant of itself)
     * the approach I did was to first set up a current node variable to the root of the tree to start the traversal
     * we then create a while loop that will continue until the current node is null
     * inside of the while loop we test for three cases
     * if both p and q are greater than the current node we know that both nodes must be in the right subtree so we set the current node to the right child of the current node
     * if both p and q are less than the current node we know that both nodes must be in the left subtree so we set the current node to the left child of the current node
     * otherwise we know that we have found the lowest common ancestor and we return the current node
     * the time complexity of this approach is O(h) where h is the height of the tree since we are only traversing down the height of the tree
     * the space complexity is O(1) since we are not using any additional data structures
     */


    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        lowestCommonAncestorBST tree = new lowestCommonAncestorBST();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(tree.lowestCommonAncestor(root, p, q).val);
    }
}
