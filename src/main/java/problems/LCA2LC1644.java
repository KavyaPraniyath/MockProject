package problems;

public class LCA2LC1644 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean[] found = new boolean[2];
        TreeNode lca = lowestCommonAncestor(root, p, q, found);
        return (found[0] && found[1]) ? lca : null;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, boolean[] found) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q, found);
        TreeNode right = lowestCommonAncestor(root.right, p, q, found);
        if (root == p){
            found[0] = true;
            return root;
        }
        if (root == q){
            found[1] = true;
            return root;
        }
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
        LCA2LC1644 solution = new LCA2LC1644();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }
}
