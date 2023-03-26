public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        String[] f = new String[3];
        String.join(", ", f);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            if (left.left.val != right.right.val || left.right.val != right.left.val) {
                return false;
            } else {
                boolean f = false;
                if (left.left != null && right.right != null) {
                    f = isSymmetric(left.left, right.right);
                } else if (left.right != null &&  right.left != null) {
                    f = isSymmetric(left.right, right.left);
                } else if (left.left == null && right.right == null && left.right == null &&  right.left == null){
                    return true;
                }
                return f;
            }
        }

    }
}

