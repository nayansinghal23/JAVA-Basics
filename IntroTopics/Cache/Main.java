import enums.EvictionPolicy;
import facade.CacheFacade;
import strategy.CachingStrategy;

public class Main {
    public static void main(String[] args) {
        CachingStrategy<Integer, Integer> cache = CacheFacade.createCache(EvictionPolicy.LRU, 2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Value of key 1 : " + cache.get(1));
        cache.put(3, 3);
        System.out.println("Value of key 2 : " + cache.get(2));
    }
}
