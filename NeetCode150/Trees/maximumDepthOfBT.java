public class maximumDepthOfBT {

    /*
     * The problem is Maximum Depth of Binary Tree which is an easy tree problem on leetcode
     * the problem provides you with a binary tree and you must return its maximum depth
     * the maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node
     * a leaf is a node with no children
     * the approach I did was a basic recursion approach which is O(n) time and O(h) space complexity where h is the height of the tree
     * the approach is also called depth first search and does as the name implies
     * we start off by checking the node if it is null we return 0 since the depth of an empty tree is 0
     * otherwise we get the max depth of the left and right subtrees by recursively calling the function on the left and right children
     * finally we return 1 + the max depth of the left and right subtrees meaning we included our current node and we want the max depth of the children
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        maximumDepthOfBT tree = new maximumDepthOfBT();
        TreeNode p = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        System.out.println(tree.maxDepth(p));
        System.out.println(tree.maxDepth(q));
    }
}
