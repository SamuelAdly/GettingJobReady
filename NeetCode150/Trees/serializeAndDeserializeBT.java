public class serializeAndDeserializeBT {

    /*
     * Serialize and Deserialize Binary Tree is a hard tree problem on leetcode
     * given a binary tree we must serialize it into a string and then deserialize it back into a binary tree
     * the approach I took was a depth first search approach which is O(n) time and O(n) space complexity
     * we start off by creating a StringBuilder to store the serialized string
     * going into the serialize method we check if the root is null if so we return "null," meaning we have no tree but if we want to recreate it we need to know that it is null
     * if the root is not null we call the dfs function with the root node
     * the dfs function is a recursive function that will traverse the tree and add the value of each node to the StringBuilder
     * we start off by checking if the node is null if so we return since there is nothing to add
     * then we add the value of the node to the StringBuilder
     * then we call the dfs function with the left and right child nodes
     * 
     * going into the deserialize method we first split the string by commas to get an array of values so that each value is its own index
     * we then create an index array to keep track of our current index in the values array
     * we then call the buildTree function with the values array and the index array
     * the buildTree function is a recursive function that will build the tree by calling itself with the left and right child nodes
     * we start off by checking if the current value is "null" if so we increment the index and return null since there is no node to add
     * if the current value is not "null" we create a new TreeNode with the current value and increment the index
     * then we call the buildTree function with the left and right child nodes and set them to the left and right child nodes of the current node
     * finally we return the current node
     */
    StringBuilder sb = new StringBuilder();
    
    public String serialize (TreeNode root) {
        if (root == null) return "null,";
        dfs(root);
        return sb.toString();
    }

        public void dfs (TreeNode node) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left);
        dfs(node.right);
    }

    public TreeNode deserialize (String data) {
        String[] values = data.split(",");
        int[] index = {0};
        return buildTree(values, index);
    }

    public TreeNode buildTree(String[] values, int[] index) {
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]++]));
        root.left = buildTree(values, index);
        root.right = buildTree(values, index);
        return root;
    }

    public static void main (String[] args) {
        serializeAndDeserializeBT sol = new serializeAndDeserializeBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(sol.serialize(root));
    }
}
