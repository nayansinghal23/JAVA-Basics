package facade;

import enums.EvictionPolicy;
import factory.CacheFactory;
import strategy.CachingStrategy;

public class CacheFacade {
    public static void cache (EvictionPolicy evictionPolicy, int capacity) {
        CachingStrategy strategy = CacheFactory.initializeEvictionPolicy(evictionPolicy, capacity);
        strategy.put(1, 1);
        strategy.put(2, 2);
        System.out.println("Value of key 1 : " + strategy.get(1));
        strategy.put(3, 3);
        System.out.println("Value of key 2 : " + strategy.get(2));
    }
}
