package problems;

public class LCA1LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ||  root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else  {
            return root;
        }
    }

    public static void main(String[] args) {
        // Construct the binary tree: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Define nodes p and q
        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1

        // Find the lowest common ancestor
        LCA1LC236 solution = new LCA1LC236();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }
}
