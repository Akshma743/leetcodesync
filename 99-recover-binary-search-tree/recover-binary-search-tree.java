class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values of the two wrong nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Check current node with previous node
        if (prev != null && prev.val > root.val) {

            if (first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        // Right
        inorder(root.right);
    }
}