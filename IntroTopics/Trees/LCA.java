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

// It's not guaranteed that p and q are in the tree.
class LCA2 {
    private boolean foundP = false;
    private boolean foundQ = false;

    private TreeNode traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = traversal(root.left, p, q);
        TreeNode right = traversal(root.right, p, q);

        if (root.val == p.val) {
            foundP = true;
            return root;
        }

        if (root.val == q.val) {
            foundQ = true;
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foundP = false;
        foundQ = false;

        TreeNode result = traversal(root, p, q);

        if (foundP && foundQ) {
            return result;
        }

        return null;
    }
}