package problems.microsoft.lld.kvstore;

class KVNode {

    private String nodeId;
    private StorageEngine storage;

    public KVNode(String nodeId) {
        this.nodeId = nodeId;
        this.storage = new StorageEngine();
    }

    public void put(String key, String value) {
        storage.put(key, value);
    }

    public String get(String key) {
        return storage.get(key);
    }

    public void delete(String key) {
        storage.delete(key);
    }

    public String getNodeId() {
        return nodeId;
    }
}
