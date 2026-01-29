package problems;

class Node {
    int val;
    Node left;
    Node right;
    Node parent;
    public Node(int val) {
        this.val = val;
    }
}
public class LCA3LC1650 {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) {
            return null;
        }
        Node a =  p;
        Node b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
