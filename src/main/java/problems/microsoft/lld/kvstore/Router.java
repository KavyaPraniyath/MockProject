package problems.microsoft.lld.kvstore;

import java.util.List;

class Router {

    private List<KVNode> nodes;

    public Router(List<KVNode> nodes) {
        this.nodes = nodes;
    }

    public KVNode getNode(String key) {

        int hash = Math.abs(key.hashCode());

        int index = hash % nodes.size();

        return nodes.get(index);
    }
}
