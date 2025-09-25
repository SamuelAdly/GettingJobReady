import java.util.HashMap;
import java.util.Map;

class constructBTFromPreAndInorder {

    //preorder is root left right
    //inorder is left root right

    /*
     * Construct Binary Tree from Preorder and Inorder Traversal is a medium tree problem on leetcode
     * given the preorder and inorder traversal of a binary tree, construct and return the binary tree
     * you are supposed to combine your knowledge of preorder and inorder traversal to construct a tree 
     * this is difficult because you basically have to cross reference the two arrays to figure out the structure of the tree
     * the key is to use the preorder array to figure out the root node since it will always be the first element in the array
     * then you find that in the inorder array and the left side will be the left subtree and the right side will be the right subtree
     * 
     * The code does this in O(n) time and O(n) space
     * we first start off in the buildTree method where we do some edge case checking just to make sure our arrays are valid
     * then we create a map that will store the "node" as the key and the index in the inorder array as the value
     * we for loop throug h the inorder array and put each element in the map
     * then we call our helper function splitTree
     * 
     * splitTree will take in the preorder array, the map we just created, the current root index in the preorder array, and the left and right bounds of the current subtree in the inorder array
     * we create a new TreeNode with the value of the current root index in the preorder array
     * then we find the index of that value in the inorder array using our map
     * if the index is greater than the left bound then we recursively call splitTree on the left subtree
     * if the index is less than the right bound then we recursively call splitTree on the right subtree
     * then we return the root node
     */
    public TreeNode buildTree (int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inOrderMap.put(inorder[i], i);

        return splitTree(preorder, inOrderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderMap, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inOrderMap.get(preorder[rootIndex]);
        if (mid > left) root.left = splitTree(preorder, inOrderMap, rootIndex + 1, left, mid - 1);
        if (mid < right) root.right = splitTree(preorder, inOrderMap, rootIndex + mid - left + 1, mid + 1, right);
        return root;
    }

    private String printTree(TreeNode root) {
        if (root == null) return "null,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(printTree(root.left));
        sb.append(printTree(root.right));
        return sb.toString();
    }

    public static void main(String[] args) {
        constructBTFromPreAndInorder treeBuilder = new constructBTFromPreAndInorder();
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};
        TreeNode root = treeBuilder.buildTree(preorder, inorder);
        System.out.println(treeBuilder.printTree(root));
    }

}