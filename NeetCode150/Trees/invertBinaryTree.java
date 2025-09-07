public class invertBinaryTree {
    /*
     * The problem is Invert Binary Tree which is an easy tree problem on leetcode
     * the problem provides you with a binary tree and you must invert it and return its root
     * the approach I did was a basic recursion approach which is O(n) time and space complexity
     * the approach is also called depth first search and does as the name implies
     * we start off by checking the node if it is null we return null since the inverted tree of an empty tree is an empty tree
     * otherwise we get the inverted left and right subtrees by recursively calling the function on the left and right children
     * finally we return a new TreeNode with the value of the current node and the inverted left and right subtrees
     */
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public static void main(String[] args) {
        invertBinaryTree tree = new invertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode inverted = tree.invertTree(root);
        System.out.println(inverted.val);
        System.out.println(inverted.left.val);
        System.out.println(inverted.right.val);
    }
}
