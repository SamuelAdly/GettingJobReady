public class countGoodNodesinBT {
    
    /*
     * Count Good Nodes in Binary Tree is a medium tree problem on leetcode
     * given a binary tree we must return the number of good nodes in the tree
     * a good node is a node where the value of the node is greater than or equal to the maximum value of the path from the root to the node
     * the approach I did was a depth first search approach which is O(n) time and O(h) space complexity where h is the height of the tree
     * we start off by checking the node if it is null we return 0 since there are no good nodes in an empty tree
     * otherwise we check if the value of the node is greater than or equal to the maximum value of the path from the root to the node
     * if so we increment the count of good nodes by 1
     * then we recursively call the function on the left and right children of the node and pass in the maximum value of the path from the root to the node
     * finally we return the count of good nodes
     */

    public int goodNodes (TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int res = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);
        return res;
    }


    public static void main(String[] args) {
        countGoodNodesinBT tree = new countGoodNodesinBT();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(tree.goodNodes(root));
    }
}
