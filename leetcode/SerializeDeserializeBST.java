/*
        https://leetcode.com/problems/serialize-and-deserialize-bst/
*/
public class SerializeDeserializeBST {

    static void printInorder(TreeNode node) {
        if(node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
        System.out.println("Print Inroder:");
        printInorder(ans);
        System.out.println("");
    }
}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        storePreorder(root, sb);
        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] vals = data.split(",");

        TreeNode root = null;
        for(int i = 0; i < vals.length; i++) {
            root = insert(root, Integer.parseInt(vals[i]));
        }
        return root;
    }

    void storePreorder(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        sb.append(node.val + ",");
        storePreorder(node.left, sb);
        storePreorder(node.right, sb);
    }

    TreeNode insert(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        else if(root.val > val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }
}

