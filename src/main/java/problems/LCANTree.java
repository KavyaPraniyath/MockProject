package problems;

import java.util.List;

class NodeTree {
    int val;
    List<NodeTree> children;
    public NodeTree(int val) {
        this.val = val;
    }
}
public class LCANTree {
    public NodeTree lca(NodeTree root, NodeTree p, NodeTree q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        NodeTree temp = null;
        int count = 0;
        for (NodeTree child : root.children) {
            NodeTree res = lca(child, p, q);
            if (res != null) {
                temp = res;
                count++;
            }
        }
        if (count >= 2) {
            return root;
        }
        return temp;
    }

    public static void main(String[] args) {
        LCANTree lca = new LCANTree();

        // Create the tree
        NodeTree root = new NodeTree(1);
        NodeTree child1 = new NodeTree(2);
        NodeTree child2 = new NodeTree(3);
        NodeTree child3 = new NodeTree(4);
        NodeTree child4 = new NodeTree(5);

        root.children = List.of(child1, child2);
        child1.children = List.of(child3, child4);
        child2.children = List.of();
        child3.children = List.of();
        child4.children = List.of();

        // Find LCA of nodes 4 and 5
        NodeTree lcaNode = lca.lca(root, child3, child4);
        System.out.println("LCA of 4 and 5: " + (lcaNode != null ? lcaNode.val : "null"));
    }
}
