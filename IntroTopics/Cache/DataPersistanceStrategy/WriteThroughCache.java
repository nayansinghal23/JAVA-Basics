package DataPersistanceStrategy;

import decorator.Snapshotable;
import repository.Repository;
import strategy.CachingStrategy;

public class WriteThroughCache<K, V> implements DataPersistanceStrategy<K, V> {
    private final CachingStrategy<K, V> delegate;
    private final Snapshotable<K, V> snapshotable;
    private final Repository<K, V> repository;

    public WriteThroughCache(CachingStrategy<K, V> delegate, Snapshotable<K, V> snapshotable, Repository<K, V> repository) {
        this.delegate = delegate;
        this.repository = repository;
        this.snapshotable = snapshotable;
    }
    
    @Override
    public void persist(K key, V value) {
        delegate.put(key, value);
        repository.saveAll(snapshotable.snapshot());
    }
}
