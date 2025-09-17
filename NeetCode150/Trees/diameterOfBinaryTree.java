class diameterOfBinaryTree {
    /*
     * Diameter of Binary Tree is an easy tree problem on leetcode
     * given a binary tree we must return the longest path between two nodes in the tree (aka the diameter of the tree)
     * the path may or may not pass through the root
     * the approach I did was a basic recursion approach which is O(n) time and O(h) space complexity where h is the height of the tree
     * The approach is also called depth first search and does as the name implies
     * we start off by checking the node if it is null we return 0 since the depth of an empty tree is 0
     * otherwise we get the max depth of the left and right subtrees by recursively calling the function on the left and right children
     * we also update the result variable with the max diameter found so far by comparing the current diameter (left + right) with the previous max diameter
     * finally we return 1 + the max depth of the left and right subtrees meaning we included our current node and we want the max depth of the children
     * we use an array to store the result since we want to update it in the recursive calls and we cannot do that with a primitive variable
     * we could also use a class variable to store the result but I prefer using an array
     */

    public int diameter(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    public int dfs (TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        diameterOfBinaryTree tree = new diameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Diameter of the binary tree is: " + tree.diameter(root));
    }
}