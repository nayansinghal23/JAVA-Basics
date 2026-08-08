package facade;

import enums.EvictionPolicy;
import factory.CacheFactory;
import repository.Repository;
import strategy.CachingStrategy;

public class CacheFacade {
    public static <K, V> CachingStrategy<K, V> createCache(EvictionPolicy evictionPolicy, Repository repository, int capacity) {
        CacheFactory<K, V> cacheFactory = new CacheFactory<>(capacity, repository);
        return cacheFactory.initializeEvictionPolicy(evictionPolicy);
    }
}
