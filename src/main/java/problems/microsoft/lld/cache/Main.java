package problems.microsoft.lld.cache;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<CacheNode> nodes = new ArrayList<>();

        nodes.add(new CacheNode("Node1", 2));
        nodes.add(new CacheNode("Node2", 2));
        nodes.add(new CacheNode("Node3", 2));

        DistributedCache cache = new DistributedCache(nodes);

        cache.put("user1", "A");
        cache.put("user2", "B");
        cache.put("user3", "C");

        System.out.println(cache.get("user1"));
        System.out.println(cache.get("user2"));
        System.out.println(cache.get("user3"));
    }
}
