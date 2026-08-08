package factory;

import java.util.HashMap;
import java.util.Map;

import enums.EvictionPolicy;
import strategy.CachingStrategy;
import strategy.LFUCachingStrategy;
import strategy.LRUCachingStrategy;

public class CacheFactory<K, V> {
    private final Map<EvictionPolicy, CachingStrategy<K, V>> cacheRegistry = new HashMap<>();

    public CacheFactory(int capacity) {
        seedCacheRegistry(capacity);
    }

    public CachingStrategy<K, V> initializeEvictionPolicy(EvictionPolicy evictionPolicy) {
        CachingStrategy<K, V> strategy = cacheRegistry.get(evictionPolicy);
        if (strategy == null) throw new IllegalArgumentException("Eviction policy doesn't exists.");
        return strategy;
    }

    private void seedCacheRegistry(int capacity) {
        cacheRegistry.put(EvictionPolicy.LRU, new LRUCachingStrategy<>(capacity));
        cacheRegistry.put(EvictionPolicy.LFU, new LFUCachingStrategy<>(capacity));
    }
}
