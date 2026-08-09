package repository;

import java.util.HashMap;
import java.util.Map;

public class Disk<K, V> implements Repository<K, V> {
    private final Map<K, V> storage = new HashMap<>();

    @Override
    public void saveAll(Map<K, V> data) {
        storage.clear();
        storage.putAll(data);
        System.out.println("Storing cached data to disk: " + storage);
    }

    @Override
    public Map<K, V> loadAll() {
        System.out.println("Loading cached data from disk: " + storage);
        return new HashMap<>(storage);
    }
}
