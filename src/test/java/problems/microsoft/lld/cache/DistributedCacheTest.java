package problems.microsoft.lld.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DistributedCacheTest {

    DistributedCache cache;

    @BeforeEach
    void setup() {

        List<CacheNode> nodes = new ArrayList<>();

        nodes.add(new CacheNode("Node1", 2));
        nodes.add(new CacheNode("Node2", 2));
        nodes.add(new CacheNode("Node3", 2));

        cache = new DistributedCache(nodes);
    }

    @Test
    void testPutAndGet() {

        cache.put("user1", "A");

        String result = cache.get("user1");

        assertEquals("A", result);
    }

    @Test
    void testCacheMiss() {

        String result = cache.get("unknown");

        assertNull(result);
    }

    @Test
    void testLRUEviction() {

        CacheNode node = new CacheNode("Node1", 2);

        node.put("A", "1");
        node.put("B", "2");

        node.get("A");  // A becomes MRU

        node.put("C", "3"); // should evict B

        assertNull(node.get("B"));
        assertEquals("1", node.get("A"));
        assertEquals("3", node.get("C"));
    }

    @Test
    void testUpdateExistingKey() {

        cache.put("user1", "A");

        cache.put("user1", "B");

        String result = cache.get("user1");

        assertEquals("B", result);
    }

    @Test
    void testNodeCapacityIsolation() {

        CacheNode node = new CacheNode("NodeTest", 2);

        node.put("A", "1");
        node.put("B", "2");

        node.put("C", "3");

        assertNull(node.get("A")); // evicted
        assertEquals("2", node.get("B"));
        assertEquals("3", node.get("C"));
    }

    @Test
    void testMultipleKeysDistribution() {

        cache.put("user1", "A");
        cache.put("user2", "B");
        cache.put("user3", "C");

        assertEquals("A", cache.get("user1"));
        assertEquals("B", cache.get("user2"));
        assertEquals("C", cache.get("user3"));
    }
}
