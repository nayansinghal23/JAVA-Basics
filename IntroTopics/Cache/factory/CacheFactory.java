package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import decorator.PersistentCachingStrategy;
import enums.EvictionPolicy;
import repository.Repository;
import strategy.CachingStrategy;
import strategy.LFUCachingStrategy;
import strategy.LRUCachingStrategy;

public class CacheFactory<K, V> {
    private final Map<EvictionPolicy, CachingStrategy<K, V>> cacheRegistry = new HashMap<>();

    public CacheFactory(int capacity, Function<EvictionPolicy, Repository<K, V>> repositoryProvider) {
        seedCacheRegistry(capacity, repositoryProvider);
    }

    public CachingStrategy<K, V> initializeEvictionPolicy(EvictionPolicy evictionPolicy) {
        CachingStrategy<K, V> strategy = cacheRegistry.get(evictionPolicy);
        if (strategy == null) throw new IllegalArgumentException("Eviction policy doesn't exists.");
        return strategy;
    }

    private void seedCacheRegistry(int capacity, Function<EvictionPolicy, Repository<K, V>> repositoryProvider) {
        LRUCachingStrategy<K, V> lru = new LRUCachingStrategy<>(capacity);
        cacheRegistry.put(EvictionPolicy.LRU, new PersistentCachingStrategy<>(lru, lru, repositoryProvider.apply(EvictionPolicy.LRU)));

        LFUCachingStrategy<K, V> lfu = new LFUCachingStrategy<>(capacity);
        cacheRegistry.put(EvictionPolicy.LFU, new PersistentCachingStrategy<>(lfu, lfu, repositoryProvider.apply(EvictionPolicy.LFU)));
    }
}
