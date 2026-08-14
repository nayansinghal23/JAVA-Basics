package decorator;

import java.util.Map;

import DataPersistanceStrategy.DataPersistanceStrategy;
import DataPersistanceStrategy.WriteThroughCache;
import repository.Repository;
import strategy.CachingStrategy;

public class PersistentCachingStrategy<K, V> implements CachingStrategy<K, V> {
    private final CachingStrategy<K, V> delegate;
    private final Repository<K, V> repository;
    private final DataPersistanceStrategy<K, V> dataPersistanceStrategy;

    public PersistentCachingStrategy(CachingStrategy<K, V> delegate, Snapshotable<K, V> snapshotable, Repository<K, V> repository) {
        this.delegate = delegate;
        this.repository = repository;

        dataPersistanceStrategy = new WriteThroughCache<>(delegate, snapshotable, repository);

        loadFromRepository();
    }

    private void loadFromRepository() {
        for (Map.Entry<K, V> entry : repository.loadAll().entrySet()) {
            delegate.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V get(K key) {
        return delegate.get(key);
    }

    @Override
    public void put(K key, V value) {
        dataPersistanceStrategy.persist(key, value);
    }
}
