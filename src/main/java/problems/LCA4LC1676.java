package problems;

import java.util.Arrays;
import java.util.HashSet;

public class LCA4LC1676 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<TreeNode> set = new HashSet<>(Arrays.asList(nodes));
        return lca(root, set);
    }
    private TreeNode lca(TreeNode root, HashSet<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = lca(root.left, set);
        TreeNode right = lca(root.right, set);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
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

        // Define the nodes array
        TreeNode[] nodes = {root.left.right.right, root.left.right.left}; // Nodes 4 and 7

        // Find the lowest common ancestor
        LCA4LC1676 solution = new LCA4LC1676();
        TreeNode lca = solution.lowestCommonAncestor(root, nodes);

        // Print the result
        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }
}
