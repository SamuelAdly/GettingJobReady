public class balancedBinaryTree {

    private boolean checkBalance(TreeNode node) {
        return false;
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
        System.out.println(tree.checkBalance(p));
        System.out.println(tree.checkBalance(q));
        System.out.println(tree.checkBalance(r));
    }
}
