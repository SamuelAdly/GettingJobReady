
import java.util.ArrayList;
import java.util.List;

/*
 * Binary Tree Level Order Traversal is a medium tree problem on leetcode
 * given a binary tree we must return the level order traversal of the tree (aka left to right level by level)
 * the approach I did was a depth first search approach which is O(n) time and O(n) space complexity
 * we start off by creating a result list of lists to store the final result
 * then we call the dfs function with the root node and level 0
 * the dfs function is a recursive function that will traverse the tree and add the value of each node to the result list
 * we start off by checking if the node is null if so we return since there is nothing to add
 * then we check if the level is equal to the size of the result list if so we add a new list to the result list since we are at a new level
 * then we add the value of the node to the list at the current level
 * then we call the dfs function with the left and right child nodes and increment the level by 1
 * finally we return the result list
 */

public class binaryTreeLevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main (String[] args) {
        binaryTreeLevelOrderTraversal solution = new binaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
