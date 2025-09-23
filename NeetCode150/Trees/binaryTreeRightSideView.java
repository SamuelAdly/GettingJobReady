import java.util.ArrayList;
import java.util.List;

class binaryTreeRightSideView {

    /*
     * Binary Tree Right Side View is a medium tree problem on leetcode
     * given a binary tree we must return the right side view of the tree (aka right to left side view)
     * the approach I did was a depth first search approach which is O(n) time and O(n) space complexity
     * we start off by creating a result list to store the final result
     * then we call the dfs function with the root node and level 0
     * the dfs function is a recursive function that will traverse the tree and add the value of each node to the result list
     * we start off by checking if the node is null if so we return since there is nothing to add
     * then we check if the level is equal to the size of the result list if so we add the value of the node to the result list
     * then we call the dfs function with the left and right child nodes and increment the level by 1
     * finally we return the result list
     */


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(node.val);
        }
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }

    public static void main(String[] args) {
        binaryTreeRightSideView sol = new binaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(sol.rightSideView(root));
    }
}