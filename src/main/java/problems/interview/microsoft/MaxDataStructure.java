package problems.interview.microsoft;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class MaxDataStructure {

    private Set<Integer> set;
    private PriorityQueue<Integer> maxHeap;

    public MaxDataStructure() {
        set = new HashSet<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    // Insert element
    public void insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            maxHeap.add(val);
            System.out.println(val + " inserted");
        } else {
            System.out.println(val + " already exists");
        }
    }

    // Check if element exists
    public boolean get(int val) {
        return set.contains(val);
    }

    // Get maximum element
    public int getMax() {
        if (maxHeap.isEmpty()) {
            throw new RuntimeException("No elements present");
        }
        return maxHeap.peek();
    }

    // Delete element
    public void delete(int val) {

        if (!set.contains(val)) {
            System.out.println(val + " not found");
            return;
        }

        set.remove(val);
        maxHeap.remove(val);

        System.out.println(val + " deleted");
    }

    // Print current elements
    public void printState() {
        System.out.println("Set : " + set);
        System.out.println("Heap: " + maxHeap);
        System.out.println();
    }

    public static void main(String[] args) {

        MaxDataStructure ds = new MaxDataStructure();

        // Insert elements
        ds.insert(10);
        ds.insert(5);
        ds.insert(30);
        ds.insert(20);

        ds.printState();

        // Check elements
        System.out.println("Does 5 exist? " + ds.get(5));
        System.out.println("Does 100 exist? " + ds.get(100));

        System.out.println();

        // Get maximum element
        System.out.println("Max element: " + ds.getMax());

        System.out.println();

        // Delete elements
        ds.delete(30);

        ds.printState();

        System.out.println("New Max element: " + ds.getMax());
    }
}
