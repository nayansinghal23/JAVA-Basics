package repository;

import java.util.Map;

public interface Repository<K, V> {
    void saveAll(Map<K, V> data);
    Map<K, V> loadAll();
}
