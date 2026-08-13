package factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import decorator.PersistentCachingStrategy;
import decorator.TTLCachingStrategy;
import enums.EvictionPolicy;
import repository.Repository;
import strategy.CachingStrategy;
import strategy.LFUCachingStrategy;
import strategy.LRUCachingStrategy;

public class CacheFactory<K, V> {
    private static final int DEFAULT_TTL_SECONDS = 5 * 60;

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
        CachingStrategy<K, V> lruWithTtl = new TTLCachingStrategy<>(lru, lru, DEFAULT_TTL_SECONDS);
        cacheRegistry.put(EvictionPolicy.LRU, new PersistentCachingStrategy<>(lruWithTtl, lru, repositoryProvider.apply(EvictionPolicy.LRU)));

        LFUCachingStrategy<K, V> lfu = new LFUCachingStrategy<>(capacity);
        CachingStrategy<K, V> lfuWithTtl = new TTLCachingStrategy<>(lfu, lfu, DEFAULT_TTL_SECONDS);
        cacheRegistry.put(EvictionPolicy.LFU, new PersistentCachingStrategy<>(lfuWithTtl, lfu, repositoryProvider.apply(EvictionPolicy.LFU)));
    }
}
