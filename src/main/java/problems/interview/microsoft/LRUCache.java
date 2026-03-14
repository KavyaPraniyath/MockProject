package problems.interview.microsoft;

import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node newnode) {
        m.put(newnode.key, newnode);
        newnode.next = head.next;
        head.next.prev = newnode;
        head.next = newnode;
        newnode.prev = head;
    }

    private void deleteNode(Node node) {
        m.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            deleteNode(resNode);
            addNode(resNode);
            return resNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            deleteNode(m.get(key));
        }

        if (m.size() == cap) {
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
    }
}
