class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.left == null) { // means key == node.val
                return root.right;
        } else if (root.right == null) { // means key == node.val
                return root.left;
        } else { // means key == node.val

            TreeNode leftSubtree = root.right.left;
            root.right.left = root.left;

            if (leftSubtree != null) {
                fixRight(root.left, leftSubtree);
            }
            return root.right;
        }
    }

    void fixRight(TreeNode node, TreeNode leftSubtree) {
        if (node.right == null) {
            node.right = leftSubtree;
            return;
        }
        fixRight(node.right, leftSubtree);
    }

}
