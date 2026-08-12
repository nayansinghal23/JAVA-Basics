package decorator;

import java.util.Map;

import repository.Repository;
import strategy.CachingStrategy;

public class PersistentCachingStrategy<K, V> implements CachingStrategy<K, V> {
    private final CachingStrategy<K, V> delegate;
    private final Snapshotable<K, V> snapshotable;
    private final Repository<K, V> repository;

    public PersistentCachingStrategy(CachingStrategy<K, V> delegate, Snapshotable<K, V> snapshotable, Repository<K, V> repository) {
        this.delegate = delegate;
        this.snapshotable = snapshotable;
        this.repository = repository;

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
        delegate.put(key, value);
        repository.saveAll(snapshotable.snapshot());
    }
}
