package problems.microsoft.lld.filesystem;

import java.util.*;

class FileSystem {

    // Node class representing folder/file
    class Node {
        int value;
        Map<String, Node> children;

        Node(int value) {
            this.value = value;
            this.children = new HashMap<>();
        }
    }

    private Node root;

    public FileSystem() {
        root = new Node(-1); // root directory
    }

    // Create a file path with a value
    public boolean createPath(String path, int value) {

        String[] parts = path.split("/");
        Node curr = root;

        // Traverse all directories except last
        for (int i = 1; i < parts.length - 1; i++) {

            if (!curr.children.containsKey(parts[i]))
                return false;

            curr = curr.children.get(parts[i]);
        }

        String last = parts[parts.length - 1];

        if (curr.children.containsKey(last))
            return false;

        curr.children.put(last, new Node(value));

        return true;
    }

    // Get value of a file path
    public int get(String path) {

        String[] parts = path.split("/");
        Node curr = root;

        for (int i = 1; i < parts.length; i++) {

            if (!curr.children.containsKey(parts[i]))
                return -1;

            curr = curr.children.get(parts[i]);
        }

        return curr.value;
    }

    // LS method
    public List<String> ls(String path) {

        String[] parts = path.split("/");
        Node curr = root;

        for (int i = 1; i < parts.length; i++) {

            if (parts[i].isEmpty()) continue;

            if (!curr.children.containsKey(parts[i]))
                return new ArrayList<>();

            curr = curr.children.get(parts[i]);
        }

        List<String> result = new ArrayList<>(curr.children.keySet());
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        FileSystem fs = new FileSystem();

        System.out.println(fs.createPath("/a", 1));     // true
        System.out.println(fs.createPath("/a/b", 2));   // true
        System.out.println(fs.createPath("/a/c", 3));   // true
        System.out.println(fs.createPath("/x", 4));     // true

        System.out.println(fs.get("/a"));      // 1
        System.out.println(fs.get("/a/b"));    // 2

        System.out.println(fs.ls("/"));        // [a, x]
        System.out.println(fs.ls("/a"));       // [b, c]
    }
}
