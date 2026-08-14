// https://leetcode.com/problems/path-sum-iii/

public class PathSum {
    private int ans = 0;

    private int countPaths(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int count = 0;
        targetSum -= root.val;
        if (targetSum == 0) count++;
        count += countPaths(root.left, targetSum);
        count += countPaths(root.right, targetSum);

        return count;
    }

    private void preorder(TreeNode root, long targetSum) {
        if(root == null) return;

        ans += countPaths(root, targetSum);
        preorder(root.left, targetSum);
        preorder(root.right, targetSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        preorder(root, targetSum);
        return ans;
    }
}

// Solution 2 : Prefix Sum
class Solution {
    private int ans = 0;
    private final Map<Long, Integer> map = new HashMap<>();

    private void preorder(TreeNode root, int targetSum, long sum) {
        if(root == null) return;

        sum += root.val;
        if(map.getOrDefault(sum - targetSum, 0) > 0) ans += map.get(sum - targetSum);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        preorder(root.left, targetSum, sum);
        preorder(root.right, targetSum, sum);

        // Remove current node's prefix sum -> Because when we finish exploring a node, its prefix sum no longer belongs to the current path, so we remove it to prevent it from incorrectly matching paths in another branch.
        map.put(sum, map.get(sum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        map.put(0L, 1);
        preorder(root, targetSum, 0);
        return ans;
    }
}