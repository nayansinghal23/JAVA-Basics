package facade;

import enums.EvictionPolicy;
import factory.CacheFactory;
import strategy.CachingStrategy;

public class CacheFacade {
    public static <K, V> CachingStrategy<K, V> createCache(EvictionPolicy evictionPolicy, int capacity) {
        CacheFactory<K, V> cacheFactory = new CacheFactory<>(capacity);
        return cacheFactory.initializeEvictionPolicy(evictionPolicy);
    }
}
