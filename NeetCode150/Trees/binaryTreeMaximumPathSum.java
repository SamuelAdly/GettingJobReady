class binaryTreeMaximumPathSum {

    /*
     * Binary Tree Maximum Path Sum is a hard tree problem on leetcode
     * the problem provides you with a binary tree and you must return the maximum path sum of the tree
     * the maximum path sum is the sum of a sequence of nodes where each pair of adjacent nodes has an edge connecting them resulting in a path with the largest sum
     * a path can start and end at any node in the tree (it can not split off. think of it as a straight line)
     * the approach I did was a post order traversal approach which is O(n) time and O(n) space complexity 
     * it performs a bottom up approach where we traverse the tree and calculate the maximum path sum at each node
     * we first initialize a max variable to -infinity because some trees might consist of all negative values and max = 0 with give bad results
     * then we just call the postorder function on the root node and return the max variable
     * the postorder function is what does the work
     * we start off by checking the node if it is null we return 0 since the path sum of an empty tree is 0
     * otherwise we get the max path sum of the left and right subtrees by recursively calling the function on the left and right children
     * this is done through leftmax and rightmax variables
     * they recursively call the postorder function on the left and right children but using the max function to compare the result with 0 so that we do not include negative path sums
     * then we calculate the maximum path sum at the current node by adding the leftmax, rightmax, and the value of the current node
     * we then update the max variable if the current path sum is greater than the current max variable
     * finally we return the maximum path sum that can be extended to the parent node which is the maximum of the leftmax and rightmax plus the value of the current node
     * this is because we can only extend one path to the parent node
     * the function continues to recursively call itself until all nodes have been visited and the max variable contains the maximum path sum of the entire tree
     */


    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return max;
    }

    public int postorder (TreeNode root) {
        if (root == null) return 0;

        int leftMax = Math.max(postorder(root.left), 0);
        int rightMax = Math.max(postorder(root.right), 0);
        max = Math.max(max, leftMax + rightMax + root.val);
        return  Math.max(leftMax, rightMax) + root.val;
    }

    public static void main (String[] args) {
        binaryTreeMaximumPathSum solution = new binaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(solution.maxPathSum(root));
    }
}