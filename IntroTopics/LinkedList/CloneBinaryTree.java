public class CloneBinaryTree {
    // https://www.geeksforgeeks.org/problems/clone-a-binary-tree/1

    private void inorder(Tree root, Map<Tree, Tree> map) {
        if(root == null) return;
        
        inorder(root.left, map);
        map.put(root, new Tree(root.data));
        inorder(root.right, map);
    }
    
    private void preorder(Tree root, Map<Tree, Tree> map) {
        if(root == null) return;
        
        Tree clonedRoot = map.getOrDefault(root, null);
        Tree clonedLeft = root.left != null ? map.getOrDefault(root.left, null) : null;
        Tree clonedRight = root.right != null ? map.getOrDefault(root.right, null) : null;
        Tree clonedRandom = root.random != null ? map.getOrDefault(root.random, null) : null;
        clonedRoot.left = clonedLeft;
        clonedRoot.right = clonedRight;
        clonedRoot.random = clonedRandom;
        
        preorder(root.left, map);
        preorder(root.right, map);
    }

    public Tree cloneTree(Tree root) {
        // add code here.
        if(root == null) return null;

        Map<Tree, Tree> map = new HashMap<>();
        inorder(root, map);
        preorder(root, map);
        return map.getOrDefault(root, null);
    }
}
