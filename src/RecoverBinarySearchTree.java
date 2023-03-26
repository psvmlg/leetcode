public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        new RecoverBinarySearchTree().recoverTree(new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null));
    }

    TreeNode smallSwap = null;
    TreeNode largeSwap = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        recoverTrees(root);
        int f = smallSwap.val;
        smallSwap.val = largeSwap.val;
        largeSwap.val = f;
        System.out.println("");
    }

    public void recoverTrees(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTrees(root.left);

        if (largeSwap != null && largeSwap.val > root.val) {
            smallSwap = root;
        } else if (prev != null && root.val < prev.val) {
            if (largeSwap == null) largeSwap = prev;
            smallSwap = root;
        }
        prev = root;

        recoverTrees(root.right);
    }
}
