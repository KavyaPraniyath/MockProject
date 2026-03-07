package problems.microsoft.lld.kvstore;

import java.util.concurrent.ConcurrentHashMap;

class StorageEngine {

    private ConcurrentHashMap<String, String> store;

    public StorageEngine() {
        store = new ConcurrentHashMap<>();
    }

    public void put(String key, String value) {
        store.put(key, value);
    }

    public String get(String key) {
        return store.get(key);
    }

    public void delete(String key) {
        store.remove(key);
    }
}
