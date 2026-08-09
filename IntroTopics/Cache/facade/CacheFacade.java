package facade;

import java.util.function.Function;

import enums.EvictionPolicy;
import factory.CacheFactory;
import repository.Repository;
import strategy.CachingStrategy;

public class CacheFacade {
    public static <K, V> CachingStrategy<K, V> createCache(EvictionPolicy evictionPolicy, Function<EvictionPolicy, Repository<K, V>> repositoryProvider, int capacity) {
        CacheFactory<K, V> cacheFactory = new CacheFactory<>(capacity, repositoryProvider);
        return cacheFactory.initializeEvictionPolicy(evictionPolicy);
    }
}
