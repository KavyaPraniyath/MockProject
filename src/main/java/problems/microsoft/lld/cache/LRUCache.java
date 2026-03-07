package problems.microsoft.lld.cache;

import java.util.HashMap;
import java.util.Map;

class Node {
    String key;
    String value;
    Node prev;
    Node next;

    Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private int capacity;
    private Map<String, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node("","");
        tail = new Node("","");

        head.next = tail;
        tail.prev = head;
    }

    public synchronized String get(String key) {

        Node node = map.get(key);

        if(node == null)
            return null;

        remove(node);
        insertToFront(node);

        return node.value;
    }

    public synchronized void put(String key, String value) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertToFront(node);
            return;
        }

        if(map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key,value);
        insertToFront(node);
        map.put(key,node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
