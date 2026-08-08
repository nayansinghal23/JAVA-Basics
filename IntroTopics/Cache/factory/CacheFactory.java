package factory;

import java.util.HashMap;
import java.util.Map;

import enums.EvictionPolicy;
import strategy.CachingStrategy;
import strategy.LFUCachingStrategy;
import strategy.LRUCachingStrategy;

public class CacheFactory {
    private final Map<EvictionPolicy, CachingStrategy> cacheRegistry = new HashMap<>();

    public CacheFactory(int capacity) {
        seedCacheRegistry(capacity);
    }

    public CachingStrategy initializeEvictionPolicy(EvictionPolicy evictionPolicy) {
        return cacheRegistry.getOrDefault(evictionPolicy, null);
    }

    private void seedCacheRegistry(int capacity) {
        cacheRegistry.put(EvictionPolicy.LRU, new LRUCachingStrategy(capacity));
        cacheRegistry.put(EvictionPolicy.LFU, new LFUCachingStrategy(capacity));
    }
}
