package repository;

import java.util.Map;

public class Disk<K, V> implements Repository<K, V> {
    @Override
    public void saveAll(Map<K, V> data) {}

    @Override
    public Map<K, V> loadAll() {
        return null;
    }
}
