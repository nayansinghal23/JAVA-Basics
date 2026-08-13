public class BinaryTreeMaximumPathSum {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        solve(root);

        return maxSum;
    }

    public int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        // Ignore negative paths
        left = Math.max(0, left);
        right = Math.max(0, right);

        // Path passing through current node
        int currentPath = left + root.val + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return only one path to parent
        return root.val + Math.max(left, right);
    }
}
