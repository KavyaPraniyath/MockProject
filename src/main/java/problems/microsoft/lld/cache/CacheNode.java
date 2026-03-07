package problems.microsoft.lld.cache;

class CacheNode {

    private LRUCache cache;
    private String nodeId;

    public CacheNode(String nodeId, int capacity) {
        this.nodeId = nodeId;
        this.cache = new LRUCache(capacity);
    }

    public String get(String key) {
        return cache.get(key);
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String getNodeId() {
        return nodeId;
    }
}
