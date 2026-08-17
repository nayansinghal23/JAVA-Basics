public class ValidateBST {
    // https://leetcode.com/problems/validate-binary-search-tree/description/
    
    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;

        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;

        List<Integer> nodes = new ArrayList<>();

        inorder(root, nodes);

        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) <= nodes.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}
