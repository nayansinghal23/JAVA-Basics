package factory;

import enums.EvictionPolicy;
import strategy.CachingStrategy;
import strategy.LFUCachingStrategy;
import strategy.LRUCachingStrategy;

public class CacheFactory {
    public static CachingStrategy initializeEvictionPolicy(EvictionPolicy evictionPolicy, int capacity) {
        if(evictionPolicy == EvictionPolicy.LRU) return new LRUCachingStrategy(2);
        else if(evictionPolicy == EvictionPolicy.LFU) return new LFUCachingStrategy(capacity);
        throw new IllegalArgumentException("Eviction policy doesn't exists.");
    }
}
