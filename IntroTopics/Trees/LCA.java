public class LCA {
    private boolean isLCA(TreeNode left, TreeNode right, TreeNode p, TreeNode q) {
        if (left == null || right == null) {
            return false;
        }

        return ((left.val == p.val || left.val == q.val) &&
                (right.val == p.val || right.val == q.val));
    }

    private TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = traversal(root.left, p, q);
        TreeNode right = traversal(root.right, p, q);

        if (root.val == p.val ||
            root.val == q.val ||
            isLCA(left, right, p, q)) {
            return root;
        }

        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }
}
