package DataPersistanceStrategy;

public interface DataPersistanceStrategy<K, V> {
    void persist(K key, V value);
}
