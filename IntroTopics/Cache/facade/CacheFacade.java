package facade;

import enums.EvictionPolicy;
import factory.CacheFactory;
import strategy.CachingStrategy;

public class CacheFacade {
    public static void cache (EvictionPolicy evictionPolicy, int capacity) {
        CacheFactory cacheFactory = new CacheFactory(capacity);
        CachingStrategy strategy = cacheFactory.initializeEvictionPolicy(evictionPolicy);
        if(strategy == null) throw new IllegalArgumentException("Eviction policy doesn't exists.");

        strategy.put(1, 1);
        strategy.put(2, 2);
        System.out.println("Value of key 1 : " + strategy.get(1));
        strategy.put(3, 3);
        System.out.println("Value of key 2 : " + strategy.get(2));
    }
}
