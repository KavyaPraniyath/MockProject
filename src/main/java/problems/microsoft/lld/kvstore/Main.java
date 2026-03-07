package problems.microsoft.lld.kvstore;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<KVNode> nodes = new ArrayList<>();

        nodes.add(new KVNode("Node1"));
        nodes.add(new KVNode("Node2"));
        nodes.add(new KVNode("Node3"));

        DistributedKVStore store = new DistributedKVStore(nodes);

        store.put("user1", "Alice");
        store.put("user2", "Bob");

        System.out.println(store.get("user1"));
        System.out.println(store.get("user2"));

        store.delete("user1");

        System.out.println(store.get("user1"));
    }
}
