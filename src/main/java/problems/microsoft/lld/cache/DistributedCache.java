package problems.microsoft.lld.cache;

import java.util.List;

class DistributedCache {

    private CacheRouter router;

    public DistributedCache(List<CacheNode> nodes) {
        this.router = new CacheRouter(nodes);
    }

    public void put(String key, String value) {

        CacheNode node = router.getNode(key);

        node.put(key, value);
    }

    public String get(String key) {

        CacheNode node = router.getNode(key);

        return node.get(key);
    }
}
