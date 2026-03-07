package problems.microsoft.lld.cache;

import java.util.List;

class CacheRouter {

    private List<CacheNode> nodes;

    public CacheRouter(List<CacheNode> nodes) {
        this.nodes = nodes;
    }

    public CacheNode getNode(String key) {

        int hash = Math.abs(key.hashCode());

        int index = hash % nodes.size();

        return nodes.get(index);
    }
}
