public class balancedBinaryTree {
    /*
     * Balanced Binary Tree is an easy Tree leetcode problem
     * the problem provides you with a tree and you must check if it is balanced or not
     * if it is return true if not return false
     * 
     * the approach I did was a basic recursion approach which is O(n^2) time and O(n) space complexity
     * we start off in the main function that was given to us (isBalanced) and we check if the node is null if so we return true since an empty tree is balanced
     * then we get the heights of the left and right subtrees using the helper function height
     * when called we check if the node is null if so we return 0 since the height of an empty tree is 0
     * if not we return 1 + the max height of the left and right subtrees meaning we included our current node and we want the max height of the children as we recursively call them
     * finally we go back to the isBalanced function and we check if the absolute difference between the left and right heights is less than or equal to 1 (meaning of balanced)
     * and we also call the isBalanced function on the left and right children to ensure that they are also balanced
     * 
     * The optimal approach which is O(n) time and O(h) space complexity where h is the height of the tree
     * we use a depth first search approach which basically means we go as deep as possible in the tree before backtracking
     * we start off by returning dfs(node)[0] == 1 which means we are checking if the first element of the array returned by dfs is 1 (meaning balanced)
     * in the dfs function we check if the node is null if so we return an array of {1, 0} meaning it is balanced and has a height of 0
     * if not we call dfs on the left and right children and we return an array of {balanced, height} where balanced is 1 if the tree is balanced and 0 if not and height is the height of the tree
     * we check if the left and right subtrees are balanced and if the absolute difference between their heights is less than or equal to 1
     * if so we set balanced to true otherwise false
     * we then calculate the height of the current node by taking the max height of the left and right subtrees and adding 1 to account for the current node
     * finally we return the array of {balanced ? 1 : 0, height}
     */

    public boolean isBalanced(TreeNode node, String s) {
        if (s.equals("Brute")) {
            if (node == null) return true;
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left, s) && isBalanced(node.right, s);
        } else {
            return dfs(node)[0] == 1;
        }
        
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {1, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] {balanced ? 1 : 0, height};
    }


    public static void main(String[] args) {
        balancedBinaryTree tree = new balancedBinaryTree();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)));
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);
        r.right.right = new TreeNode(4);
        r.right.right.right = new TreeNode(5);
        System.out.println(tree.isBalanced(p, "Brute"));
        System.out.println(tree.isBalanced(q, "Brute"));
        System.out.println(tree.isBalanced(r, "Brute"));
        System.out.println(tree.isBalanced(p, "Optimal"));
        System.out.println(tree.isBalanced(q, "Optimal"));        
        System.out.println(tree.isBalanced(r, "Optimal"));
    }
}
