package problems.microsoft.lld.kvstore;

import java.util.List;

class DistributedKVStore {

    private Router router;

    public DistributedKVStore(List<KVNode> nodes) {
        router = new Router(nodes);
    }

    public void put(String key, String value) {

        KVNode node = router.getNode(key);

        node.put(key, value);
    }

    public String get(String key) {

        KVNode node = router.getNode(key);

        return node.get(key);
    }

    public void delete(String key) {

        KVNode node = router.getNode(key);

        node.delete(key);
    }
}
